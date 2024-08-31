package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.GroceryListDto
import com.groupe.gestionrecettes.data.model.IngredientDto
import com.groupe.gestionrecettes.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserApiService {

    @GET("/api/grocery-lists")
    suspend fun getUserGroceries(@Header("Authorization") token: String): List<GroceryListDto>

    @GET("/api/utilisateurs/{userId}/ingredients")
    suspend fun getUserIngredients(@Path("userId") userId: Int, @Header("Authorization") token: String): List<IngredientDto>
}