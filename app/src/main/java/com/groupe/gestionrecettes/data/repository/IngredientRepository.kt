package com.groupe.gestionrecettes.data.repository

import com.groupe.gestionrecettes.data.api.RetrofitInstance
import okhttp3.ResponseBody

class IngredientRepository {
    private val ingredientApi = RetrofitInstance.ingredientApiService
    private val categoryApi = RetrofitInstance.ingredientCategoryApiService

    suspend fun getIngredients() = ingredientApi.getIngredients()

    suspend fun getIngredientsByCategory(categoryId: Int) = ingredientApi.getIngredientsByCategory(categoryId)

    suspend fun getCategories() = categoryApi.getCategories()

    suspend fun getCategoryIcon(categoryId: Int): String? {
        val response = categoryApi.getIcon(categoryId)
        return if (response.isSuccessful) {
            "http://victorl.xyz:8081/api/ingredient-categories/$categoryId/icon"
        } else {
            null
        }
    }
}
