package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.ui.composables.ScreenPicker
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.viewmodel.IngredientViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.groupe.gestionrecettes.ui.composables.IngredientListByCategory

@Composable
fun PantryScreen(navController: NavController, viewModel: IngredientViewModel = hiltViewModel()) {
    var selectedScreen by remember { mutableStateOf("Liste de courses") }
    val categoriesWithIngredients by viewModel.categoriesWithIngredients.collectAsState()
    val isLoading = categoriesWithIngredients.isEmpty()

    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                // Screen Picker for navigating between screens
                ScreenPicker(
                    options = listOf("Liste de courses", "Garde-manger"),
                    selectedOption = selectedScreen,
                    onOptionSelected = { selectedScreen = it }
                )
                Spacer(modifier = Modifier.height(16.dp))

                when (selectedScreen) {
                    "Liste de courses" -> {
                        Text(
                            text = "Displaying Liste de courses content",
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    "Garde-manger" -> {
                        // Display different states for loading, empty, and content
                        when {
                            isLoading -> {
                                // Loading state
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }

                            categoriesWithIngredients.isEmpty() -> {
                                // Empty state
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "No categories available.",
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }
                            }

                            else -> {
                                LazyColumn(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    contentPadding = PaddingValues(16.dp)
                                ) {
                                    items(categoriesWithIngredients.toList()) { (category, ingredients) ->
                                        IngredientListByCategory(
                                            category = category,
                                            ingredients = ingredients
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val navController = rememberNavController()
    val viewModel = IngredientViewModel() // Previewing with a simple ViewModel instantiation
    PantryScreen(navController, viewModel)
}
