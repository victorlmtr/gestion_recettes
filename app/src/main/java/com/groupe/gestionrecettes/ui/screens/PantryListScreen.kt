package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.groupe.gestionrecettes.data.viewmodel.IngredientViewModel
import com.groupe.gestionrecettes.ui.composables.IngredientListByCategory

@Composable
fun PantryListScreen(viewModel: IngredientViewModel= hiltViewModel()) {
    val categoriesWithIngredients by viewModel.categoriesWithIngredients.collectAsState()
    val isLoading = categoriesWithIngredients.isEmpty()

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