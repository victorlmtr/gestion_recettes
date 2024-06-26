package com.groupe.gestionrecettes.data

sealed class Screens(val route : String) {
    object Home : Screens("home_screen")
    object Recipes : Screens("recipes_screen")
    object Pantry : Screens("pantry_screen")
    object Profile : Screens("profile_screen")
    object Login : Screens("login_screen")
    object RecipeDetails : Screens("recipe_details/{recipeId}") {
        fun createRoute(recipeId: Int) = "recipe_details/$recipeId"
    }
    object RecipeStep : Screens("recipe_step/{recipeId}/{stepIndex}") {
        fun createRoute(recipeId: Int, stepIndex: Int) = "recipe_step/$recipeId/$stepIndex"
    }
}

