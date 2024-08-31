package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.RecipeCarousel
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun HomeScreen(navController: NavController) {
    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    SearchBar()
                }
                item {
                    SectionTitle(title = "Ça pourrait vous plaire")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Végétarien")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Postés récemment")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
                item {
                    SectionTitle(title = "Les plus likés")
                    RecipeCarousel(navController = navController, recipes = recipes)
                }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeCarouselPreview() {
    val navController = rememberNavController()
    ScrontchTheme {
        HomeScreen(navController)
    }

}

