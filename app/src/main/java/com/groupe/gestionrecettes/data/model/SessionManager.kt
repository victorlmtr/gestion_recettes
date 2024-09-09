package com.groupe.gestionrecettes.data.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
        companion object {
            private const val USER_ID = "user_id"
            private const val USERNAME = "username"
            private const val EMAIL = "email_utilisateur"
            private const val DATE_CREATION = "date_creation_utilisateur"
            private const val ACCESS_TOKEN = "access_token"
            private const val REFRESH_TOKEN = "refresh_token"
            private const val IS_LOGGED_IN = "is_logged_in"
        }

        fun saveAuthToken(accessToken: String?, refreshToken: String?) {
            if (accessToken != null && refreshToken != null) {
                prefs.edit().apply {
                    putString(ACCESS_TOKEN, accessToken)
                    putString(REFRESH_TOKEN, refreshToken)
                    putBoolean(IS_LOGGED_IN, true)
                    apply()
                }
            } else {
                Log.e("SessionManager", "Cannot save auth tokens: tokens are null")
            }
        }

        fun saveUserDetails(user: UserDto) {
            prefs.edit().apply {
                putInt(USER_ID, user.id)
                putString(USERNAME, user.nomUtilisateur)
                putString(EMAIL, user.emailUtilisateur)
                putString(DATE_CREATION, user.dateCreationUtilisateur)
                apply()
            }
        }

        fun fetchUserDetails(): UserDto? {
        val userId = prefs.getInt(USER_ID, -1)
        if (userId == -1) return null

        val username = prefs.getString(USERNAME, null)
        val email = prefs.getString(EMAIL, null)
        val dateCreation = prefs.getString(DATE_CREATION, null)

        return if (username != null && email != null && dateCreation != null) {
            UserDto(id = userId, nomUtilisateur = username, emailUtilisateur = email, mdpUtilisateur = "", dateCreationUtilisateur = dateCreation)
        } else null
    }

        fun fetchAuthToken(): String? {
            return prefs.getString(ACCESS_TOKEN, null)
        }

        fun fetchUserId(): Int? {
            val userId = prefs.getInt(USER_ID, -1)
            return if (userId == -1) null else userId
        }

        fun isLoggedIn(): Boolean {
            return prefs.getBoolean(IS_LOGGED_IN, false)
        }

        fun clearSession() {
            prefs.edit().clear().apply()
        }
    }
