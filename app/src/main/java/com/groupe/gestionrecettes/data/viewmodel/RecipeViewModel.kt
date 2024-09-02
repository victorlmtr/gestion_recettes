package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.Recipe
import com.groupe.gestionrecettes.data.api.RecetteApiService
import com.groupe.gestionrecettes.data.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> get() = _recipes

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    private val _recipeDetails = MutableStateFlow<Recipe?>(null) // Added for recipe details
    val recipeDetails: StateFlow<Recipe?> get() = _recipeDetails // Exposed as StateFlow

    private val recetteApiService: RecetteApiService = RetrofitInstance.retrofit.create(RecetteApiService::class.java)

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val fetchedRecipes = recetteApiService.getAllRecipes()
                _recipes.value = fetchedRecipes
            } catch (e: Exception) {
                _error.value = e.localizedMessage
            } finally {
                _loading.value = false
            }
        }
    }

    // New method to fetch a single recipe by its ID
    fun getRecipeById(id: Int?) {
        if (id == null) {
            _error.value = "Invalid Recipe ID"
            return
        }

        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val fetchedRecipe = recetteApiService.getRecipeById(id) // Assuming this API call exists
                _recipeDetails.value = fetchedRecipe
            } catch (e: Exception) {
                _error.value = e.localizedMessage
            } finally {
                _loading.value = false
            }
        }
    }
}
