package com.groupe.gestionrecettes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.composables.UnselectableChip
import com.groupe.gestionrecettes.ui.composables.UnselectableChipIcon
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.ui.composables.StarRating
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar
import com.groupe.gestionrecettes.data.viewmodel.RecipeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeDetailsScreen(
    navController: NavController,
    recipeId: Int,
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
            } else if (error == null) {
                // Display recipe details
                Scaffold(
                    topBar = {
                        SurveyTopAppBar(
                            questionIndex = 0,
                            totalQuestionsCount = 3,
                            stepName = "Recipe"
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
                                UnselectableChipIcon("Végétarien", ByteArray(0)) // Provide default or empty icon
                                UnselectableChip("Afrique du Nord")
                            }

                            StarRating(1.5f, 5)

                            // Use Coil to load the image from the URL
                            val imageUrl = "https://images.victorl.xyz/step5.jpg"
                            val painter = rememberAsyncImagePainter(imageUrl)
                            Image(
                                painter = painter,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp)
                                    .padding(vertical = 12.dp)
                            )

                            Text(
                                text = "No Description",
                                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                                modifier = Modifier.padding(vertical = 8.dp)
                            )

                            Text(
                                text = "Durée totale :",
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
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreenPreview() {
    ScrontchTheme {
        val navController = rememberNavController()
        RecipeDetailsScreen(navController, 1)
    }
}
