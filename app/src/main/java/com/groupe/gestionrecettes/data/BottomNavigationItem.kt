package com.groupe.gestionrecettes.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.ui.graphics.vector.ImageVector
import com.groupe.gestionrecettes.ui.BottomBarScreen

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Default.Home,
    val route : String = ""
) {

    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Accueil",
                icon = Icons.Default.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Recettes",
                icon = Icons.Default.RestaurantMenu,
                route = Screens.Recipes.route
            ),
            BottomNavigationItem(
                label = "Courses",
                icon = Icons.Default.Kitchen,
                route = Screens.Pantry.route
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Default.AccountCircle,
                route = Screens.Profile.route
            ),
        )
    }
}