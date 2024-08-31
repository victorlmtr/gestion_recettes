package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.groupe.gestionrecettes.data.Recipe
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

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
                imageRes = recipes[index].imageRes,
                chipLabel1 = recipes[index].category,
                chipLabel2 = recipes[index].country,
                chipIcon1 = recipes[index].categoryIcon,
                recipeLength = recipes[index].length,
                userCount = recipes[index].userCount,
                rating = recipes[index].rating,
                badgeCount = recipes[index].badgeCount,
                onClick = {
                    navController.navigate(Screens.RecipeDetails.createRoute(recipes[index].id))
                }
            )
        }
    }

    // Add indicators if desired
    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun RecipeCarouselPreview() {
    ScrontchTheme {
        val navController = rememberNavController()
        RecipeCarousel(navController = navController, recipes = recipes)
    }
}