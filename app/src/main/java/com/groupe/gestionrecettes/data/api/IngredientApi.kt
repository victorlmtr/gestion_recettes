package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.Ingredient
import retrofit2.http.GET
import retrofit2.http.Path

interface IngredientApi {
    @GET("/api/ingredients")
    suspend fun getIngredients(): List<Ingredient>

    @GET("/api/ingredients/categorieIngredient/{id}")
    suspend fun getIngredientsByCategory(@Path("id") categoryId: Int): List<Ingredient>
}