package com.sensegrow.android.myapplication

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.sensegrow.android.myapplication.network.LoginRequest
import com.sensegrow.android.myapplication.network.LoginResponse
import com.sensegrow.android.myapplication.network.WebService
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import android.widget.Button as Button1

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button1
    var email:String = "etEmail.text.toString().trim()"
    var password:String = "password = etPassword.text.toString().trim()"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etEmail = findViewById(R.id.txtEmail)
        etPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)
//
        btnLogin.setOnClickListener{
//            etEmail = findViewById(R.id.etName)
//        etPassword = findViewById(R.id.etPassword)
//        btnLogin = findViewById(R.id.btnLogin)
            if(validate())
            {
                login(email,password)
            }

        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//        etEmail = findViewById(R.id.etName)
//        etPassword = findViewById(R.id.etPassword)
//        btnLogin = findViewById(R.id.btnLogin)

//        btnLogin.setOnClickListener{
//            etEmail = findViewById(R.id.etName)
//        etPassword = findViewById(R.id.etPassword)
//        btnLogin = findViewById(R.id.btnLogin)
//            if(validate())
//            {
//                login(email,password)
//            }
//
//        }
        return super.onCreateView(name, context, attrs)
    }

    private fun validate():Boolean{
        email = etEmail.text.toString().trim()
        password = etPassword.text.toString().trim()

        if(email.isEmpty()){
            etEmail.error = "Email required"
            etEmail.requestFocus()
            return false
        }

        if(password.isEmpty()){
            etPassword.error = "Passward required"
            etPassword.requestFocus()
            return false
        }
        return true
    }

    private fun login(email:String, password:String){
        WebService.retrofitService.userLogin(LoginRequest(email, password)).enqueue(
            object: Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
//                    TODO("Not yet implemented")
                    Log.i("MainActivity",response.code().toString())
                    Log.i("MainActivity",response.body().toString())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

}
}