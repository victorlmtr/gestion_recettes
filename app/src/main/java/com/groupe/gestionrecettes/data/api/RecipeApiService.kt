package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.Comment
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.model.IngredientWithPantryStatus
import com.groupe.gestionrecettes.data.model.Recipe
import com.groupe.gestionrecettes.data.model.RecipeIngredient
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

    @GET("/api/recipes/{id}/comments")
    suspend fun getCommentsForRecipe(@Path("id") id: Int): List<Comment>

    @POST("/api/recipes")
    suspend fun createRecipe(@Body recipe: Recipe): Recipe

    @GET("/api/recipes/{recipeId}/ingredients")
    suspend fun getIngredientsForRecipe(@Path("recipeId") recipeId: Int): List<Ingredient>

    @GET("/api/recipes/{recipeId}/missing-ingredients/{userId}")
    suspend fun getMissingIngredientsForRecipe(
        @Path("recipeId") recipeId: Int,
        @Path("userId") userId: Int
    ): List<RecipeIngredient>

    @PUT("/api/recipes/{id}")
    suspend fun updateRecipe(@Path("id") id: Int, @Body recipe: Recipe): Recipe

    @DELETE("/api/recipes/{id}")
    suspend fun deleteRecipe(@Path("id") id: Int)

    @GET("/api/utilisateurs/{id}/username")
    suspend fun getUsernameById(@Path("id") id: Int): String
}