package com.groupe.gestionrecettes.data.repository

import com.groupe.gestionrecettes.data.api.RetrofitInstance

class IngredientRepository {
    private val ingredientApi = RetrofitInstance.ingredientApi
    private val categoryApi = RetrofitInstance.categoryApi

    suspend fun getIngredients() = ingredientApi.getIngredients()

    suspend fun getIngredientsByCategory(categoryId: Int) = ingredientApi.getIngredientsByCategory(categoryId)

    suspend fun getCategories() = categoryApi.getCategories()
}