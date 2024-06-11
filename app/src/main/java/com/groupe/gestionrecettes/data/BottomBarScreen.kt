package com.groupe.gestionrecettes.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "Accueil",
        icon = Icons.Default.Home
    )

    object Recipes : BottomBarScreen(
        route = "RECIPES",
        title = "Recettes",
        icon = Icons.Default.RestaurantMenu
    )

    object Pantry : BottomBarScreen(
        route = "PANTRY",
        title = "Courses",
        icon = Icons.Default.Kitchen
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        title = "Profil",
        icon = Icons.Default.AccountCircle
    )
}
