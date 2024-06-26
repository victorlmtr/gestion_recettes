package com.groupe.gestionrecettes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.composables.UnselectableChip
import com.groupe.gestionrecettes.ui.composables.UnselectableChipIcon
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.data.Comment
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.data.countries
import com.groupe.gestionrecettes.ui.composables.CommentCard
import com.groupe.gestionrecettes.ui.composables.StarRating
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeDetailsScreen(navController: NavController, recipeId: Int?) {
    // Handle case when recipeId is null
    if (recipeId == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Erreur: Recette non trouvée",
                style = MaterialTheme.typography.titleLarge
            )
        }
        return
    }

    val recipe = recipes.find { it.id == recipeId }
    val comments = listOf(
        Comment("John Doe", 4.5f, "This is a great recipe! I really enjoyed it.", "2024-06-25"),
        Comment("Jane Smith", 5.0f, "Delicious! Will make again.", "2024-06-24"),
        Comment("Alex Johnson", 3.0f, null, "2024-06-23")
    )

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
                    text = "Erreur: Recette non trouvée",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        } else {
            Scaffold(
                topBar = {
                    SurveyTopAppBar(
                        questionIndex = 0,
                        totalQuestionsCount = 3,
                        recipeName = recipe.name,
                        onClosePressed = {
                            navController.navigate(Screens.Recipes.route)
                        }
                    )
                },
                content = { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(16.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                UnselectableChip(recipe.country.name)
                                UnselectableChipIcon("Végétarien", R.drawable.vegetables)
                                UnselectableChipIcon(recipe.category, recipe.categoryIcon)
                                UnselectableChip(recipe.country.continent.name)
                            }

                            StarRating(recipe.rating, 5)

                            Image(
                                painter = painterResource(recipe.imageRes),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp)
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

                            Text(
                                text = "Commentaires",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }

                        items(comments.size) { index ->
                            val comment = comments[index]
                            CommentCard(
                                username = comment.username,
                                starRating = comment.starRating,
                                comment = comment.comment,
                                commentDate = comment.date
                            )
                        }
                    }
                },
                bottomBar = {
                    SurveyBottomBar(
                        shouldShowPreviousButton = false,
                        shouldShowDoneButton = false,
                        isNextButtonEnabled = true,
                        onPreviousPressed = {},
                        onNextPressed = {
                            navController.navigate(Screens.RecipeStep.createRoute(recipeId, 0))
                        },
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
        val navController = rememberNavController()
        RecipeDetailsScreen(navController, 0)
    }
}
