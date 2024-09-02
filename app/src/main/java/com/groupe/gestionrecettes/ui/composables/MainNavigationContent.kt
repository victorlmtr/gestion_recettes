package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.data.viewmodel.IngredientViewModel
import com.groupe.gestionrecettes.ui.screens.*

@Composable
fun MainNavigationContent(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val routesWithoutBottomBar = listOf(Screens.RecipeDetails.route, Screens.RecipeStep.route)
    val ingredientViewModel = hiltViewModel<IngredientViewModel>()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (currentDestination?.route !in routesWithoutBottomBar) {
                BottomNavigationBar(navController = navController, currentRoute = currentDestination?.route)
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) { HomeScreen(navController) }
            composable(Screens.Recipes.route) { RecipesScreen(navController) }
            composable(Screens.Pantry.route) { PantryScreen(navController, ingredientViewModel) }
            composable(Screens.Profile.route) { ProfileScreen(navController) }
            composable(Screens.Login.route) { LoginScreen(navController) }
            composable(Screens.RecipeDetails.route) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull()
                RecipeDetailsScreen(navController, recipeId, recipeViewModel = hiltViewModel())
            }
            composable(Screens.RecipeStep.route) { backStackEntry ->
                val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull()
                val stepIndex = backStackEntry.arguments?.getString("stepIndex")?.toIntOrNull()
                if (recipeId != null && stepIndex != null) {
                    RecipeStepScreen(navController, recipeId, stepIndex)
                }
            }
        }
    }
}
