package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.composables.UnselectableChip
import com.groupe.gestionrecettes.ui.composables.UnselectableChipIcon
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.composables.StarRating

@Composable
fun RecipeDetailsScreen(recipeId: Int?) {
    // Find the recipe by recipeId
    val recipe = recipeId?.let { id ->
        recipes.find { it.id == id }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Recipe Title
            if (recipe == null) {
                Text(
                    text = "Erreur",
                    style = MaterialTheme.typography.titleLarge
                )
            } else {
                SurveyTopAppBar(questionIndex = 0, totalQuestionsCount = 3, recipeName = recipe.name) {

                }
                Row(modifier = Modifier) {
                    UnselectableChip("Tunisie")
                    UnselectableChipIcon("Végétarien", R.drawable.vegetables)
                    UnselectableChipIcon("Œufs", R.drawable.dairy)
                    UnselectableChip("Afrique du Nord")
                }
                StarRating(recipe.rating, 5)
                // Recipe Image
                recipe?.imageRes?.let { imageRes ->
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = 12.dp)
                    )
                }

                // Recipe Length
                Text(recipe.description, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Durée totale : ${recipe.length}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Add more details if needed (e.g., user count, rating, etc.)
                // Example:
                // Text(text = "User Count: ${recipe?.userCount ?: 0}")

                // You can customize the UI further based on your requirements
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreenPreview() {
    GestionRecettesTheme {
        RecipeDetailsScreen(0)
    }
}