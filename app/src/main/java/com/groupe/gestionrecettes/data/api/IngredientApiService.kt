package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.Ingredient
import retrofit2.http.GET
import retrofit2.http.Path

interface IngredientApiService {
    @GET("/api/ingredients")
    suspend fun getIngredients(): List<Ingredient>

    @GET("/api/ingredients/category/{id}")
    suspend fun getIngredientsByCategory(@Path("id") categoryId: Int): List<Ingredient>
}