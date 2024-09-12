package com.groupe.gestionrecettes.data.repository

import com.groupe.gestionrecettes.data.api.RecetteApiService
import com.groupe.gestionrecettes.data.model.Comment
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.model.IngredientWithPantryStatus
import com.groupe.gestionrecettes.data.model.Recipe
import com.groupe.gestionrecettes.data.model.RecipeIngredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val apiService: RecetteApiService
) {

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> get() = _recipes

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    suspend fun fetchRecipes() {
        _loading.value = true
        _error.value = null
        try {
            val fetchedRecipes = apiService.getAllRecipes()
            _recipes.update { fetchedRecipes }
        } catch (e: Exception) {
            _error.value = e.localizedMessage
        } finally {
            _loading.value = false
        }
    }

    suspend fun getRecipeById(id: Int): Recipe? { // Return type is Recipe?
        _loading.value = true
        _error.value = null
        return try {
            val fetchedRecipe = apiService.getRecipeById(id)
            fetchedRecipe // Return the fetched recipe
        } catch (e: Exception) {
            _error.value = e.localizedMessage
            null // Return null in case of error
        } finally {
            _loading.value = false
        }
    }
    suspend fun getCommentsForRecipe(id: Int): List<Comment> {
        _loading.value = true
        _error.value = null
        return try {
            val comments = apiService.getCommentsForRecipe(id)
            comments // Return the list of comments
        } catch (e: Exception) {
            _error.value = e.localizedMessage
            emptyList() // Return an empty list in case of error
        } finally {
            _loading.value = false
        }
    }
    suspend fun getIngredientsForRecipe(recipeId: Int): List<Ingredient> {
        return apiService.getIngredientsForRecipe(recipeId)
    }

    suspend fun getMissingIngredients(recipeId: Int, userId: Int): List<RecipeIngredient> {
        return apiService.getMissingIngredientsForRecipe(recipeId, userId)
    }

    suspend fun getUsernameById(id: Int): String? {
        _loading.value = true
        _error.value = null
        return try {
            val username = apiService.getUsernameById(id)
            username
        } catch (e: Exception) {
            _error.value = e.localizedMessage
            null
        } finally {
            _loading.value = false
        }
    }
}
