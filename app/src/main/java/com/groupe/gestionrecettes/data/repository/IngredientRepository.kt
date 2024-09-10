package com.groupe.gestionrecettes.data.repository

import com.groupe.gestionrecettes.data.api.IngredientApiService
import com.groupe.gestionrecettes.data.api.IngredientCategoryApiService
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.model.IngredientCategory
import okhttp3.ResponseBody
import retrofit2.Response

open class IngredientRepository(
    private val ingredientApiService: IngredientApiService,
    private val ingredientCategoryApiService: IngredientCategoryApiService
) {
    suspend fun getIngredients() = ingredientApiService.getIngredients()

    suspend fun getIngredientsByCategory(categoryId: Int) = ingredientApiService.getIngredientsByCategory(categoryId)

    suspend fun getCategories() = ingredientCategoryApiService.getCategories()

}
