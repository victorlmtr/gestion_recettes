package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NoFood
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.Sms
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.ProfileItem
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.ui.composables.ProfileSection
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun ProfileScreen(navController: NavController) {
    ScrontchTheme {
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
                                navController.navigate(Screens.Login.route) // Navigate to Login screen
                            },
                            ProfileItem("Mes préférences alimentaires", Icons.Default.NoFood),
                            ProfileItem("Mes favoris", Icons.Default.Favorite),
                            ProfileItem("Mes commentaires", Icons.AutoMirrored.Filled.Comment)
                        )
                    )
                }

                // Divider between sections
                item {
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                }

                // App Settings Section
                item {
                    ProfileSection(
                        sectionName = "Paramètres de l'application",
                        items = listOf(
                            ProfileItem("Notifications", Icons.Default.Notifications),
                            ProfileItem("Mode sombre", Icons.Default.DarkMode),
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