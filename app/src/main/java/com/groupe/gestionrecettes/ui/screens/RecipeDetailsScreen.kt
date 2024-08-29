package com.groupe.gestionrecettes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeDetailsScreen(recipeId: Int?, content: @Composable (PaddingValues) -> Unit) {
    // Find the recipe by recipeId
    val recipe = recipeId?.let { id ->
        recipes.find { it.id == id }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (recipe == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Erreur",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        } else {
            Scaffold(
                topBar = {
                    SurveyTopAppBar(
                        questionIndex = 0,
                        totalQuestionsCount = 3,
                        stepName = recipe.name
                    ) {}
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(18.dp)
                            .padding(top = 56.dp),  // Add padding to account for the TopAppBar height
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            UnselectableChip("Tunisie")
                            UnselectableChipIcon("Végétarien", R.drawable.vegetables)
                            UnselectableChip("Afrique du Nord")
                        }

                        StarRating(recipe.rating, 5)

                        Image(
                            painter = painterResource(recipe.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                                .padding(vertical = 12.dp)
                        )

                        Text(
                            text = recipe.description,
                            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        Text(
                            text = "Durée totale : ${recipe.length}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )

                        // Additional details can be added here
                    }
                },
                bottomBar = {
                    SurveyBottomBar(
                        shouldShowPreviousButton = true,
                        shouldShowDoneButton = false,
                        isNextButtonEnabled = true,
                        onPreviousPressed = {},
                        onNextPressed = {},
                        onDonePressed = {}
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreenPreview() {
    GestionRecettesTheme {
        RecipeDetailsScreen(1, {})
    }
}
