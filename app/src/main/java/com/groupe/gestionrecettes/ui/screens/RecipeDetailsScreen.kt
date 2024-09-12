package com.groupe.gestionrecettes.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.data.helpers.formatDurationToFrench
import com.groupe.gestionrecettes.ui.composables.SurveyTopAppBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.ui.composables.StarRating
import com.groupe.gestionrecettes.ui.composables.SurveyBottomBar
import com.groupe.gestionrecettes.data.viewmodel.RecipeViewModel
import com.groupe.gestionrecettes.ui.composables.CommentCard
import com.groupe.gestionrecettes.ui.composables.IngredientItem
import com.groupe.gestionrecettes.ui.composables.RecipeHeader

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeDetailsScreen(
    navController: NavController,
    recipeId: Int,
    userId: Int?,
    recipeViewModel: RecipeViewModel = hiltViewModel() // Inject RecipeViewModel
) {
    LaunchedEffect(recipeId, userId) {
        recipeViewModel.getRecipeById(recipeId)
        if (userId != null) {
            recipeViewModel.getIngredientsWithPantryStatus(recipeId, userId)
        } else {
            recipeViewModel.getIngredients(recipeId)
        }
    }

    val loading by recipeViewModel.loading.collectAsState()
    val error by recipeViewModel.error.collectAsState()
    val recipe by recipeViewModel.recipe.collectAsState()
    val comments by recipeViewModel.comments.collectAsState()

    // Separate states for ingredients with and without pantry status
    val ingredientsWithPantryStatus by recipeViewModel.ingredientsWithPantryStatus.collectAsState()
    val ingredientsWithoutPantryStatus by recipeViewModel.ingredients.collectAsState()
    val recipeIngredients by recipeViewModel.recipeIngredients.collectAsState()

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
            } else if (recipe != null) {
                // Display recipe details
                Scaffold(
                    topBar = {
                        val stepCount = recipe!!.etapes.size
                        SurveyTopAppBar(
                            questionIndex = 0,
                            totalQuestionsCount = stepCount + 1,
                            stepName = recipe!!.libRecette
                        ) {}
                    },
                    content = { paddingValues -> // Add padding values to content scope
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()  // Ensure LazyColumn fills the available size
                                .padding(paddingValues)  // Use the padding provided by Scaffold
                                .padding(horizontal = 18.dp, vertical = 12.dp),  // Additional padding for content
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                recipe?.let { rec ->
                                    RecipeHeader(rec) // Extracted the header to a separate composable

                                    StarRating(1.5f, 5)
                                    val imageUrl = rec.imageRecette
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
                                        text = rec.descriptionRecette ?: "No Description",
                                        style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                                        modifier = Modifier.padding(vertical = 8.dp)
                                    )

                                    // Ingredients Section
                                    Text(
                                        text = "Ingrédients",
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    if (userId != null) {
                                        recipeIngredients.forEach { recipeIngredient ->
                                            IngredientItem(
                                                ingredient = recipeIngredient.ingredient.libIngredient,
                                                inPantry = recipeIngredient.inPantry,
                                                qty = recipeIngredient.ingredientRecette.quantite,
                                                unit = recipeIngredient.ingredientRecette.idUniteMesure.libUniteMesure,
                                                details = recipeIngredient.ingredientRecette.idIngredientDetails.libIngredientDetails,
                                                onAddToGroceryList = {
                                                    // Handle add to grocery list action
                                                }
                                            )
                                        }
                                    } else {
                                        ingredientsWithoutPantryStatus.forEach { ingredient ->
                                            IngredientItem(
                                                ingredient = ingredient.libIngredient ?: "Unknown Ingredient",
                                                inPantry = false,
                                                qty = 0.0,
                                                unit = "",
                                                details = "",
                                                onAddToGroceryList = {
                                                    // Handle add to grocery list action
                                                }
                                            )
                                        }
                                    }

                                    comments.forEach { comment ->
                                        CommentCard(
                                            username = comment.idUtilisateur?.nomUtilisateur ?: "Unknown User",
                                            starRating = comment.noteAvis.toFloat(),
                                            comment = comment.commentaireAvis ?: "No Comment",
                                            commentDate = comment.dateCommentaire?.toString() ?: "Unknown Date"
                                        )
                                    }
                                }
                            }
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





