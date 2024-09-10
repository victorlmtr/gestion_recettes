package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RecetteApiService {
    @GET("/api/recipes")
    suspend fun getAllRecipes(): List<Recipe>

    @GET("/api/recipes/{id}")
    suspend fun getRecipeById(@Path("id") id: Int): Recipe

    @POST("/api/recipes")
    suspend fun createRecipe(@Body recipe: Recipe): Recipe

    @PUT("/api/recipes/{id}")
    suspend fun updateRecipe(@Path("id") id: Int, @Body recipe: Recipe): Recipe

    @DELETE("/api/recipes/{id}")
    suspend fun deleteRecipe(@Path("id") id: Int)
}