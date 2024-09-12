package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.model.Screens
import com.groupe.gestionrecettes.ui.composables.RecipeSmallCardClickable
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.composables.SelectableChip
import com.groupe.gestionrecettes.ui.composables.SelectableChipIcon
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.viewmodel.RecipeViewModel
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.data.viewmodel.AuthViewModel


@Composable
fun RecipesScreen(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel(),
    recipeViewModel: RecipeViewModel = hiltViewModel()
) {
    var isTomatoChipSelected by remember { mutableStateOf(false) }
    var isIndiaChipSelected by remember { mutableStateOf(false) }
    var isVegetableChipSelected by remember { mutableStateOf(false) }
    var isBeefChipSelected by remember { mutableStateOf(false) }

    // Fetch the recipes from the backend
    val recipes by recipeViewModel.recipes.collectAsState()
    val loading by recipeViewModel.loading.collectAsState()
    val error by recipeViewModel.error.collectAsState()
    val userDetails by authViewModel.userDetails.collectAsState()
    val isLoggedIn = userDetails != null
    val userId = userDetails?.id

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SearchBar()

        // Chips for filtering (if needed)
        Row(modifier = Modifier.fillMaxWidth()) {
            SelectableChip(
                label = "Tomates",
                selected = isTomatoChipSelected,
                onSelectedChange = { isTomatoChipSelected = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            SelectableChip(
                label = "Inde",
                selected = isIndiaChipSelected,
                onSelectedChange = { isIndiaChipSelected = it }
            )
            SelectableChipIcon(
                label = "Légumes",
                iconRes = "https://images.victorl.xyz/type1.png",
                selected = isVegetableChipSelected,
                onSelectedChange = { isVegetableChipSelected = it }
            )
            SelectableChipIcon(
                label = "Bœuf",
                iconRes = "https://images.victorl.xyz/type2.png",
                selected = isBeefChipSelected,
                onSelectedChange = { isBeefChipSelected = it }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Show loading, error, or recipes
        when {
            loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
            error != null -> {
                Text(
                    text = "Error: $error",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            }
            else -> {
                // Display the list of recipes
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(recipes) { recipe ->
                        RecipeSmallCardClickable(
                            recipe = recipe,
                            onClick = {
                                navController.navigate(Screens.RecipeDetails.createRoute(recipe.id, userId))
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp)) // Adjust spacing between cards as needed
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreview() {
    ScrontchTheme {
        val navController = rememberNavController()
        RecipesScreen(navController)
    }
}
