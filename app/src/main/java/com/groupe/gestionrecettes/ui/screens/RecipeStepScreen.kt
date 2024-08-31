package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun RecipeStepScreen(navController: NavController, recipeId: Int, stepIndex: Int?) {
    val recipe = recipes.find { it.id == recipeId }
    val step = stepIndex?.let { recipe?.steps?.getOrNull(it) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (recipe == null || step == null) {
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
            val isLastStep = stepIndex == recipe.steps.lastIndex

            Scaffold(
                topBar = {
                    SurveyTopAppBar(
                        questionIndex = stepIndex + 1,
                        totalQuestionsCount = recipe.steps.size + 1,
                        stepName = recipe.name,
                        onClosePressed = {
                            navController.navigate(Screens.Recipes.route)
                        }
                    )
                },
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = step.instructions,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                },
                bottomBar = {
                    SurveyBottomBar(
                        shouldShowPreviousButton = true,
                        shouldShowDoneButton = isLastStep,
                        isNextButtonEnabled = true,
                        onPreviousPressed = {
                            if (stepIndex > 0) {
                                navController.navigate(Screens.RecipeStep.createRoute(recipeId, stepIndex - 1))
                            } else {
                                navController.navigate(Screens.RecipeDetails.createRoute(recipeId))
                            }
                        },
                        onNextPressed = {
                            navController.navigate(Screens.RecipeStep.createRoute(recipeId, stepIndex + 1))
                        },
                        onDonePressed = {
                            navController.navigate(Screens.RecipeDetails.createRoute(recipeId))
                        }
                    )
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RecipeStepScreenPreview() {
    ScrontchTheme {
        val navController = rememberNavController()
        RecipeStepScreen(navController, 0, 0)
    }
}
