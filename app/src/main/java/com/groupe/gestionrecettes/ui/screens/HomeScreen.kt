package com.groupe.gestionrecettes.ui.screens


import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.ui.composables.RecipeCarousel
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.data.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
               authViewModel: AuthViewModel = hiltViewModel()
) {
    val userDetails by authViewModel.userDetails.collectAsState()
    val isLoggedIn = userDetails != null

    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    TopAppBar(
                        title = { Text(fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
                            text = "Scrontch") },
                        actions = {
                            IconButton(onClick = {
                                navController.navigate(Screens.Login.route)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Profile Icon"
                                )
                            }
                        }
                    )
                }

                // Greeting message
                item {
                    Text(
                        text = if (isLoggedIn) {
                            "Bonjour ${userDetails?.nomUtilisateur} !\nQu'allez-vous cuisiner aujourd'hui ?"
                        } else {
                            "Bonjour !\nQu'allez-vous cuisiner aujourd'hui ?"
                        },
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.run {
                            padding(8.dp)
                                                .fillMaxWidth()
                        }
                    )
                }

                item {
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        SearchBar()
                    }
                }

                // Recipe Sections
                item {
                    SectionTitle(title = "Ça pourrait vous plaire")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Végétarien")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Postés récemment")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Les plus likés")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
            }
        }
    }
    println("User details: $userDetails")
}

@Composable
fun SectionTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )
}

