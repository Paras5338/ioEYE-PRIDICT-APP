package network

import retrofit2.Call
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


private const val BASE_URL = "https://predict.ioeye.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface IoeyePredictApiService {
    @Headers("Content-Type:application/json")
    @POST("/api/v1/signin")
    fun userLogin(@Body loginReq: LoginRequest): Call<LoginResponse>
}


object WebService {
    val retrofitService: IoeyePredictApiService by lazy {
        retrofit.create(IoeyePredictApiService::class.java)
    }
}


