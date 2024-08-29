package com.groupe.gestionrecettes.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.api.AuthApiService
import com.groupe.gestionrecettes.data.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log
import java.io.IOException

class AuthViewModel : ViewModel() {
    private val authApiService = RetrofitInstance.authApiService

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val response = authApiService.login(username, password)
                // Handle successful response
                saveTokens(response.accessToken, response.refreshToken)
                _loginState.value = LoginState.Success
            } catch (e: IOException) {
                // Network or I/O error
                Log.e("AuthViewModel", "Network error", e)
                _loginState.value = LoginState.Error("Network error: ${e.message}")
            } catch (e: Exception) {
                // General error
                Log.e("AuthViewModel", "Login failed", e)
                _loginState.value = LoginState.Error("Login failed: ${e.message}")
            }
        }
    }

    private fun saveTokens(accessToken: String, refreshToken: String) {
        // Implement token storage here
    }

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        object Success : LoginState()
        data class Error(val message: String) : LoginState()
    }
}
