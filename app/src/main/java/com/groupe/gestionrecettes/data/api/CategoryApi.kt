package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.IngredientCategory
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {
    @GET("/api/ingredient-categories")
    suspend fun getCategories(): List<IngredientCategory>

    @GET("/api/ingredient-categories/{id}/icon")
    suspend fun getIcon(@Path("id") id: Int): Response<ResponseBody>
}