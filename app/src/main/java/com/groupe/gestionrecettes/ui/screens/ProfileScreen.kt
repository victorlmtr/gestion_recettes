package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.model.ProfileItem
import com.groupe.gestionrecettes.data.model.ToggleProfileItem
import com.groupe.gestionrecettes.ui.composables.ProfileSection
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.model.Screens

@Composable
fun ProfileScreen(navController: NavController) {
    var darkTheme by remember { mutableStateOf(false) }

    ScrontchTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // User Account Section
                item {
                    ProfileSection(
                        sectionName = "Compte utilisateur",
                        items = listOf(
                            ProfileItem("Mon compte", Icons.Default.Lock) {
                                navController.navigate(Screens.Login.route)
                            },
                            ProfileItem("Mes préférences alimentaires", Icons.Default.NoFood),
                            ProfileItem("Mes favoris", Icons.Default.Favorite),
                            ProfileItem("Mes commentaires", Icons.AutoMirrored.Filled.Comment)
                        )
                    )
                }
                // Divider between sections
                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
                }
                // App Settings Section
                item {
                    ProfileSection(
                        sectionName = "Paramètres de l'application",
                        items = listOf(
                            ProfileItem("Notifications", Icons.Default.Notifications),
                            ToggleProfileItem(
                                title = "Mode sombre",
                                icon = Icons.Default.DarkMode,
                                isChecked = remember { mutableStateOf(darkTheme) },
                                onToggle = { darkTheme = !darkTheme }
                            ),
                            ProfileItem("Mentions légales", Icons.Default.Policy),
                            ProfileItem("Conditions d'utilisation", Icons.Default.Gavel)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}
