package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.api.RecipeTypeService
import com.groupe.gestionrecettes.data.model.RecipeType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeTypeViewModel @Inject constructor(
    private val recipeTypeService: RecipeTypeService
) : ViewModel() {

    private val _recipeTypes = MutableStateFlow<List<RecipeType>>(emptyList())
    val recipeTypes: StateFlow<List<RecipeType>> = _recipeTypes

    init {
        fetchRecipeTypes()
    }

    private fun fetchRecipeTypes() {
        viewModelScope.launch {
            try {
                val fetchedTypes = recipeTypeService.getTypes()
                _recipeTypes.value = fetchedTypes
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }
}

