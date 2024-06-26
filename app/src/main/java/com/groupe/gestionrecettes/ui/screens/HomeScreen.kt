package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.RecipeCarousel
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.composables.SelectableChipIcon
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun HomeScreen(navController: NavController) {
    GestionRecettesTheme {
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
                    RecipeCarousel(recipes = recipes, navController = navController)
                }
                item {
                    SectionTitle(title = "Végétarien")
                    RecipeCarousel(recipes = recipes, navController = navController)
                }
                item {
                    SectionTitle(title = "Postés récemment")
                    RecipeCarousel(recipes = recipes, navController = navController)
                }
                item {
                    SectionTitle(title = "Les plus likés")
                    RecipeCarousel(recipes = recipes, navController = navController)
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
    GestionRecettesTheme {
        HomeScreen(navController)
    }

}

