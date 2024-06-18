package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.BottomNavigationItem
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.ui.screens.HomeScreen
import com.groupe.gestionrecettes.ui.screens.LoginScreen
import com.groupe.gestionrecettes.ui.screens.PantryScreen
import com.groupe.gestionrecettes.ui.screens.ProfileScreen
import com.groupe.gestionrecettes.ui.screens.RecipeDetailsScreen
import com.groupe.gestionrecettes.ui.screens.RecipesScreen

@Composable
fun MainNavigationContent(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val routesWithoutBottomBar = listOf(Screens.RecipeDetails.route)

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
            composable(Screens.Pantry.route) { PantryScreen(navController) }
            composable(Screens.Profile.route) { ProfileScreen(navController) }
            composable(Screens.Login.route) { LoginScreen(navController) }
            composable(Screens.RecipeDetails.route) { backStackEntry ->
                RecipeDetailsScreen(recipeId = backStackEntry.arguments?.getString("recipeId") ?: "")
            }
        }
    }
}
