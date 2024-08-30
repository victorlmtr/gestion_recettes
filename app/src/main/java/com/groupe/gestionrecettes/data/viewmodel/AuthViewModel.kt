package com.groupe.gestionrecettes.data.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.SessionManager
import com.groupe.gestionrecettes.data.api.AuthApiService
import com.groupe.gestionrecettes.data.api.LoginRequest
import com.groupe.gestionrecettes.data.api.RetrofitInstance
import com.groupe.gestionrecettes.data.api.UserApiService
import com.groupe.gestionrecettes.data.api.LoginResponse
import com.groupe.gestionrecettes.data.model.UserDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val authApiService = RetrofitInstance.authApiService
    private val userApiService: UserApiService = RetrofitInstance.userApiService
    private val sessionManager = SessionManager(application)
    private val _userDetails = MutableStateFlow<UserDto?>(null)
    val userDetails: StateFlow<UserDto?> = _userDetails

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val userId: Int) : LoginState()
        data class Error(val message: String) : LoginState()
    }

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val loginRequest = LoginRequest(username, password)
                val response: LoginResponse = authApiService.login(loginRequest)
                val accessToken = response.accessToken
                val refreshToken = response.refreshToken

                // Ensure tokens are not null
                if (accessToken != null && refreshToken != null) {
                    // Save tokens
                    sessionManager.saveAuthToken(accessToken, refreshToken)

                    // Fetch user details using token
                    val userId = sessionManager.fetchUserId()
                    val userDetails = getUserDetails(userId)
                    sessionManager.saveUserDetails(userDetails.id, userDetails.nomUtilisateur)

                    _loginState.value = LoginState.Success(userDetails.id)
                } else {
                    _loginState.value = LoginState.Error("Invalid login response: tokens are null")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }

    private suspend fun getUserDetails(userId: Int): UserDto {
        val token = sessionManager.fetchAuthToken() ?: throw Exception("No auth token found")
        return userApiService.getUserDetails(userId, "Bearer $token")
    }

    fun isLoggedIn(): Boolean {
        return sessionManager.isLoggedIn()
    }
}
