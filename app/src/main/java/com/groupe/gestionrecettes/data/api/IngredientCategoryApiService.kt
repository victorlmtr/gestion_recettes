package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.IngredientCategory
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IngredientCategoryApiService {
    @GET("/api/ingredient-categories")
    suspend fun getCategories(): List<IngredientCategory>

}