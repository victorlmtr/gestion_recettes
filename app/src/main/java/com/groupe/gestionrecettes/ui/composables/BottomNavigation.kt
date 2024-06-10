package com.groupe.gestionrecettes.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.RestaurantMenu,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_recipes))
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Kitchen,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_inventory))
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    GestionRecettesTheme {
        BottomNavigation()
    }
}