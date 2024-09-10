package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.model.Screens
import com.groupe.gestionrecettes.data.viewmodel.RecipeViewModel
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeStepScreen(
    navController: NavController,
    recipeId: Int,
    stepIndex: Int?,
    recipeViewModel: RecipeViewModel = hiltViewModel() // Inject RecipeViewModel
) {
    // Fetch the recipe details from the backend
    LaunchedEffect(recipeId) {
        recipeViewModel.getRecipeById(recipeId)
    }

    val loading by recipeViewModel.loading.collectAsState()
    val error by recipeViewModel.error.collectAsState()

    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (loading) {
                // Display a loading spinner while fetching data
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (error != null) {
                // Display an error message if there is an error
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Erreur: $error",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            } else {
                // Create a local variable for recipeState to allow smart cast
                if (error != null) {
                    // Get the specific step details
                    val step = stepIndex?.let { }

                    if (step == null) {
                        // Handle missing step
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Erreur: Étape non trouvée",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    } else {
                        val isLastStep = stepIndex == 4

                        Scaffold(
                            topBar = {
                                SurveyTopAppBar(
                                    questionIndex = stepIndex + 1,
                                    totalQuestionsCount = 4,
                                    stepName = "test",
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
                                        text = "test",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            },
                            bottomBar = {
                                SurveyBottomBar(
                                    shouldShowPreviousButton = stepIndex > 0,
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
                                        if (!isLastStep) {
                                            navController.navigate(Screens.RecipeStep.createRoute(recipeId, stepIndex + 1))
                                        }
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