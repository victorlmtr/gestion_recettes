package com.groupe.gestionrecettes.data

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Recipes : Screens("recipes_screen")
    object Pantry : Screens("pantry_screen")
    object Profile : Screens("profile_screen")
    object Login : Screens("login_screen")
    object RecipeDetails : Screens("recipe_details_screen/{recipeId}") {
        fun createRoute(recipeId: Int) = "recipe_details_screen/$recipeId"
    }
}

