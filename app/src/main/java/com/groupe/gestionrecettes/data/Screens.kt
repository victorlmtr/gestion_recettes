package com.groupe.gestionrecettes.data

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Recipes : Screens("recipes_screen")
    object Pantry : Screens("pantry_screen")
    object Profile : Screens("profile_screen")
}

