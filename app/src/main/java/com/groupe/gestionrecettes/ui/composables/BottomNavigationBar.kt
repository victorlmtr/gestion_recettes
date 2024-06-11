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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.groupe.gestionrecettes.ui.screens.PantryScreen
import com.groupe.gestionrecettes.ui.screens.ProfileScreen
import com.groupe.gestionrecettes.ui.screens.RecipesScreen

@Composable
fun BottomNavigationBar(navController: NavHostController, currentRoute: String?) {
    NavigationBar {
        BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
            NavigationBarItem(
                selected = navigationItem.route == currentRoute,
                label = { Text(navigationItem.label) },
                icon = { Icon(navigationItem.icon, contentDescription = navigationItem.label) },
                onClick = {
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}