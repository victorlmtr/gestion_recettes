package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.groupe.gestionrecettes.data.Recipe
import com.groupe.gestionrecettes.data.Screens

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecipeCarousel(navController: NavController, recipes: List<Recipe>) {
    val pagerState = rememberPagerState()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp) // Adjust height as needed
    ) {
        items(recipes.size) { index ->
            RecipeBigCard(
                recipeName = recipes[index].name,
                imageRes = recipes[index].image,
                chipLabel1 = recipes[index].type.libType,
                chipLabel2 = recipes[index].country.libPays,
                chipIcon1 = recipes[index].type.iconeType,
                recipeLength = recipes[index].totalTime,
                userCount = 3,
                rating = 2.5f,
                badgeCount = 5,
                onClick = {
                    navController.navigate(Screens.RecipeDetails.createRoute(recipes[index].id))
                }
            )
        }
    }
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier
            .padding(0.dp)
    )
}
