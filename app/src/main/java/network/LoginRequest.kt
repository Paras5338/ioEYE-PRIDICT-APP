package network

import com.squareup.moshi.Json

data class LoginRequest(@Json(name = "email") val Email: String, @Json(name = "password") val Password: String)
