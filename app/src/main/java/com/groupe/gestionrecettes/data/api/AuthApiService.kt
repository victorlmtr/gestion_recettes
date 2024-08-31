package com.groupe.gestionrecettes.data.api

import com.google.gson.annotations.SerializedName
import com.groupe.gestionrecettes.data.model.UserDto
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {
    @POST("/api/login")
    @Headers("Content-Type: application/json")
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
    @SerializedName("refresh-token") val refreshToken: String?,
    @SerializedName("user") val user: UserDto?
)
