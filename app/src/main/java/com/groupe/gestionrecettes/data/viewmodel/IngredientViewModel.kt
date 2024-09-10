package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.model.IngredientCategory
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.repository.IngredientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IngredientViewModel @Inject constructor(
    private val repository: IngredientRepository
) : ViewModel() {

    private val _categoriesWithIngredients =
        MutableStateFlow<Map<IngredientCategory, List<Ingredient>>>(emptyMap())
    val categoriesWithIngredients: StateFlow<Map<IngredientCategory, List<Ingredient>>> =
        _categoriesWithIngredients.asStateFlow()

    init {
        fetchCategoriesWithIngredients()
    }

    private fun fetchCategoriesWithIngredients() {
        viewModelScope.launch {
            try {
                // Fetch categories from repository
                val categories = repository.getCategories().filterNotNull()

                val categoriesWithIngredients = categories.associateWith { category ->
                    Log.d(
                        "IngredientViewModel",
                        "Fetching ingredients for category: ${category.libCategorieIngredient}"
                    )
                    repository.getIngredientsByCategory(category.id).filterNotNull()
                }

                // Update the state with the new data
                _categoriesWithIngredients.update { categoriesWithIngredients }
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Error fetching categories and ingredients", e)
            }
        }
    }

    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients: StateFlow<List<Ingredient>> = _ingredients

    private val _categories = MutableStateFlow<List<IngredientCategory>>(emptyList())
    val categories: StateFlow<List<IngredientCategory>> = _categories

    fun fetchIngredients() {
        viewModelScope.launch {
            try {
                _ingredients.value = repository.getIngredients().filterNotNull()
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Error fetching ingredients", e)
            }
        }
    }

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                _categories.value = repository.getCategories().filterNotNull()
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Error fetching categories", e)
            }
        }
    }

    fun fetchIngredientsByCategory(categoryId: Int) {
        viewModelScope.launch {
            try {
                _ingredients.value = repository.getIngredientsByCategory(categoryId).filterNotNull()
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Error fetching ingredients by category", e)
            }
        }
    }
}
