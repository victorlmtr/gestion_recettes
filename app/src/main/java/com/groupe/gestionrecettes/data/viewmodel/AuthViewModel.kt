package com.groupe.gestionrecettes.data.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.SessionManager
import com.groupe.gestionrecettes.data.api.AuthApiService
import com.groupe.gestionrecettes.data.api.LoginRequest
import com.groupe.gestionrecettes.data.api.LoginResponse
import com.groupe.gestionrecettes.data.model.UserDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    application: Application,
    private val authApiService: AuthApiService,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _userDetails = MutableStateFlow<UserDto?>(null)
    val userDetails: StateFlow<UserDto?> = _userDetails

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val user: UserDto) : LoginState()
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
                val user = response.user

                if (accessToken != null && refreshToken != null && user != null) {
                    sessionManager.saveAuthToken(accessToken, refreshToken)
                    sessionManager.saveUserDetails(user.id, user.nomUtilisateur)

                    _userDetails.value = user
                    Log.d("AuthViewModel", "User details updated: ${user.nomUtilisateur}")
                    _loginState.value = LoginState.Success(user)
                } else {
                    _loginState.value = LoginState.Error("Invalid login response: missing tokens or user information")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }

    fun isLoggedIn(): Boolean {
        return sessionManager.isLoggedIn()
    }
}
