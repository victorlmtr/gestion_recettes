package com.groupe.gestionrecettes.data.repository

import com.groupe.gestionrecettes.data.api.RecetteApiService
import com.groupe.gestionrecettes.data.model.Recipe
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

    suspend fun getRecipeById(id: Int) {
        _loading.value = true
        _error.value = null
        try {
            val fetchedRecipe = apiService.getRecipeById(id)
            // Handle the fetched recipe as needed
        } catch (e: Exception) {
            _error.value = e.localizedMessage
        } finally {
            _loading.value = false
        }
    }
}

