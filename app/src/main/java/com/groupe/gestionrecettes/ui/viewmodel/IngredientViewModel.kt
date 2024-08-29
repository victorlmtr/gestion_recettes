package com.groupe.gestionrecettes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.IngredientCategory
import com.groupe.gestionrecettes.data.Ingredient
import com.groupe.gestionrecettes.data.repository.IngredientRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class IngredientViewModel : ViewModel() {
    private val repository = IngredientRepository()

    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients: StateFlow<List<Ingredient>> = _ingredients

    private val _categories = MutableStateFlow<List<IngredientCategory>>(emptyList())
    val categories: StateFlow<List<IngredientCategory>> = _categories

    fun fetchIngredients() {
        viewModelScope.launch {
            _ingredients.value = repository.getIngredients()
        }
    }

    fun fetchCategories() {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
        }
    }

    fun fetchIngredientsByCategory(categoryId: Int) {
        viewModelScope.launch {
            _ingredients.value = repository.getIngredientsByCategory(categoryId)
        }
    }
}
