package com.groupe.gestionrecettes.data.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApiService {
    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): LoginResponse
}

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)
