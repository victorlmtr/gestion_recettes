package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.data.recipes
import com.groupe.gestionrecettes.ui.composables.RecipeSmallCard
import com.groupe.gestionrecettes.ui.composables.RecipeSmallCardClickable
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.composables.SelectableChip
import com.groupe.gestionrecettes.ui.composables.SelectableChipIcon
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun RecipesScreen(navController: NavController) {
    var isTomatoChipSelected by remember { mutableStateOf(false) }
    var isIndiaChipSelected by remember { mutableStateOf(false) }
    var isVegetableChipSelected by remember { mutableStateOf(false) }
    var isBeefChipSelected by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.Center
    ) {
        SearchBar()
        Row(modifier = Modifier.fillMaxWidth()) {

            SelectableChip(
                label = "Tomates",
                selected = isTomatoChipSelected,
                onSelectedChange = { isTomatoChipSelected = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            SelectableChip(
                label = "Inde",
                selected = isIndiaChipSelected,
                onSelectedChange = { isIndiaChipSelected = it }
            )
            SelectableChipIcon(
                label = "Légumes",
                iconRes = R.drawable.vegetables,
                selected = isVegetableChipSelected,
                onSelectedChange = { isVegetableChipSelected = it }
            )
            SelectableChipIcon(
                label = "Bœuf",
                iconRes = R.drawable.beef,
                selected = isBeefChipSelected,
                onSelectedChange = { isBeefChipSelected = it }
            )

        }

        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(recipes.size) { index ->
                RecipeSmallCardClickable(
                    recipe = recipes[index],
                    onClick = {
                        navController.navigate(Screens.RecipeDetails.createRoute(recipes[index].id))
                    }
                )
                Spacer(modifier = Modifier.height(16.dp)) // Adjust spacing between cards as needed
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreview() {
    GestionRecettesTheme {
    val navController = rememberNavController()
    RecipesScreen(navController)
        }
}