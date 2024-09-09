package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.repository.RecipeRepository
import com.groupe.gestionrecettes.data.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipes: StateFlow<List<Recipe>> = repository.recipes
    val loading: StateFlow<Boolean> = repository.loading
    val error: StateFlow<String?> = repository.error

    init {
        viewModelScope.launch {
            repository.fetchRecipes()
        }
    }

    fun getRecipeById(id: Int) {
        viewModelScope.launch {
            repository.getRecipeById(id)
        }
    }
}
