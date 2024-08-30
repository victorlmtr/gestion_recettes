package com.groupe.gestionrecettes.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.api.RetrofitInstance
import com.groupe.gestionrecettes.data.api.UserApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log
import com.groupe.gestionrecettes.data.TokenManager

class UserViewModel(context: Context) : ViewModel() {
    private val userApiService = RetrofitInstance.userApiService
    private val tokenManager = TokenManager(context)

 //   private val _userGroceries = MutableStateFlow<List<Groceries>>(emptyList())
 //   val userGroceries: StateFlow<List<Groceries>> = _userGroceries

 //   private val _userFavorites = MutableStateFlow<List<Favorites>>(emptyList())
 //   val userFavorites: StateFlow<List<Favorites>> = _userFavorites

    fun fetchUserGroceries() {
        viewModelScope.launch {
            val token = "Bearer ${tokenManager.getAccessToken()}"
            try {
              //  val groceries = userApiService.getUserGroceries(token)
              //  _userGroceries.value = groceries
            } catch (e: Exception) {
                Log.e("UserViewModel", "Failed to fetch groceries", e)
            }
        }
    }

    fun fetchUserFavorites() {
        viewModelScope.launch {
            val token = "Bearer ${tokenManager.getAccessToken()}"
            try {
              //  val favorites = userApiService.getUserFavorites(token)
              //  _userFavorites.value = favorites
            } catch (e: Exception) {
                Log.e("UserViewModel", "Failed to fetch favorites", e)
            }
        }
    }
}
