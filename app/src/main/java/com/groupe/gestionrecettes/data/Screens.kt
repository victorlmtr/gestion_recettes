package com.groupe.gestionrecettes.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.RestaurantMenu
import com.groupe.gestionrecettes.ui.BottomBarScreen

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Recipes : Screens("recipes_screen")
    object Pantry : Screens("pantry_screen")
    object Profile : Screens("profile_screen")
}

