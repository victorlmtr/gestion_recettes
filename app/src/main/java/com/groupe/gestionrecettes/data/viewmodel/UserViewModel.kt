package com.groupe.gestionrecettes.data.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.api.UserApiService
import com.groupe.gestionrecettes.data.model.GroceryListDto
import com.groupe.gestionrecettes.data.model.Ingredient
import com.groupe.gestionrecettes.data.model.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userApiService: UserApiService,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _groceryList = MutableStateFlow<List<GroceryListDto>>(emptyList())
    val groceryList: StateFlow<List<GroceryListDto>> = _groceryList

    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients: StateFlow<List<Ingredient>> = _ingredients

    fun fetchUserGroceries() {
        viewModelScope.launch {
            try {
                val token = sessionManager.fetchAuthToken() ?: return@launch
                _groceryList.value = userApiService.getUserGroceries("Bearer $token")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Failed to fetch groceries", e)
            }
        }
    }

    fun fetchUserIngredients() {
        viewModelScope.launch {
            try {
                val token = sessionManager.fetchAuthToken() ?: return@launch
                val userId = sessionManager.fetchUserId()
                if (userId != null) {
                    _ingredients.value = userApiService.getUserIngredients(userId, "Bearer $token")
                } else {
                    Log.e("UserViewModel", "User ID is null")
                }
            } catch (e: Exception) {
                Log.e("UserViewModel", "Failed to fetch ingredients", e)
            }
        }
    }
}
