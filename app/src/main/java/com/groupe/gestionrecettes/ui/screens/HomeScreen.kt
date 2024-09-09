package com.groupe.gestionrecettes.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.groupe.gestionrecettes.data.model.Screens
import com.groupe.gestionrecettes.ui.composables.RecipeCarousel
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.viewmodel.AuthViewModel
import com.groupe.gestionrecettes.data.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel(),
    recipeViewModel: RecipeViewModel = hiltViewModel()
) {
    val userDetails by authViewModel.userDetails.collectAsState()
    val isLoggedIn = userDetails != null

    val recipes by recipeViewModel.recipes.collectAsState()
    val loading by recipeViewModel.loading.collectAsState()
    val error by recipeViewModel.error.collectAsState()

    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                TopAppBar(
                    title = { Text(fontFamily = MaterialTheme.typography.titleLarge.fontFamily, text = "Scrontch") },
                    actions = {
                        IconButton(
                            onClick = {
                                navController.navigate(Screens.Login.route)
                            },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile Icon",
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                )

                Text(
                    text = if (isLoggedIn) {
                        "Bonjour ${userDetails?.nomUtilisateur} !\nQu'allez-vous cuisiner aujourd'hui ?"
                    } else {
                        "Bonjour !\nQu'allez-vous cuisiner aujourd'hui ?"
                    },
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )

                SearchBar()
                Spacer(modifier = Modifier.height(8.dp))

                if (loading) {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                } else if (error != null) {
                    Text(
                        text = "Error: $error",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    val recipeCategories = listOf(
                        "Ça pourrait vous plaire" to recipes.shuffled(),
                        "Postés récemment" to recipes.sortedByDescending { it.datePublished },
                        "Les plus likés" to recipes.sortedByDescending { it.difficultyRating }
                    )

                    LazyColumn {
                        recipeCategories.forEach { (title, recipeList) ->
                            item {
                                SectionTitle(title = title)
                                RecipeCarousel(navController = navController, recipes = recipeList)
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun SectionTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )
}

