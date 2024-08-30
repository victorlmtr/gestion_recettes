package com.groupe.gestionrecettes.data.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {
    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}
data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    @SerializedName("access-token") val accessToken: String?,
    @SerializedName("refresh-token") val refreshToken: String?
)
