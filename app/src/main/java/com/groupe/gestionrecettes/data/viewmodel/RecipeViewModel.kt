package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.model.Comment
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.model.IngredientWithPantryStatus
import com.groupe.gestionrecettes.data.repository.RecipeRepository
import com.groupe.gestionrecettes.data.model.Recipe
import com.groupe.gestionrecettes.data.model.RecipeIngredient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    // List of recipes (for a list screen)
    val recipes: StateFlow<List<Recipe>> = repository.recipes
    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments: StateFlow<List<Comment>> = _comments.asStateFlow()
    val loading: StateFlow<Boolean> = repository.loading
    val error: StateFlow<String?> = repository.error

    private val _recipeIngredients = MutableStateFlow<List<RecipeIngredient>>(emptyList())
    val recipeIngredients: StateFlow<List<RecipeIngredient>> = _recipeIngredients

    // State to hold a single recipe for detail screen
    private val _recipe = MutableStateFlow<Recipe?>(null)
    open val recipe: StateFlow<Recipe?> = _recipe.asStateFlow()

    // Loading state for individual recipe fetching
    private val _loadingDetail = MutableStateFlow(false)
    val loadingDetail: StateFlow<Boolean> = _loadingDetail.asStateFlow()

    // Error state for individual recipe fetching
    private val _errorDetail = MutableStateFlow<String?>(null)
    val errorDetail: StateFlow<String?> = _errorDetail.asStateFlow()

    private val _ingredientsWithPantryStatus = MutableStateFlow<List<IngredientWithPantryStatus>>(emptyList())
    val ingredientsWithPantryStatus: StateFlow<List<IngredientWithPantryStatus>> = _ingredientsWithPantryStatus

    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients: StateFlow<List<Ingredient>> = _ingredients.asStateFlow()



    init {
        viewModelScope.launch {
            repository.fetchRecipes()
        }
    }

    fun getRecipeById(id: Int) {
        _loadingDetail.value = true // Start loading
        _errorDetail.value = null // Clear previous errors

        viewModelScope.launch {
            try {
                val fetchedRecipe = repository.getRecipeById(id)
                _recipe.value = fetchedRecipe // Set the fetched recipe
                val fetchedComments = repository.getCommentsForRecipe(id)
                _comments.value = fetchedComments
            } catch (e: Exception) {
                _errorDetail.value = e.message // Handle and set error
            } finally {
                _loadingDetail.value = false // Stop loading
            }
        }
    }
    fun getIngredientsWithPantryStatus(recipeId: Int, userId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getMissingIngredients(recipeId, userId)
                if (response.isNotEmpty()) {
                    _recipeIngredients.value = response
                } else {
                    // Handle empty response
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun getIngredients(recipeId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getIngredientsForRecipe(recipeId)  // Use the repository to fetch the ingredients
                _ingredients.value = response  // Set the fetched ingredients to the state flow
            } catch (e: Exception) {
                // Handle error, for now just print the error message
                println("Error fetching ingredients: ${e.message}")
            }
        }
    }


}
