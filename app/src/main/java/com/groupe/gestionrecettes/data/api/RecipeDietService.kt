package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.RecipeDiet
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeDietService {
    @GET("/api/diets")
    suspend fun getDiets(): List<RecipeDiet>
}