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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.data.Screens
import com.groupe.gestionrecettes.ui.composables.RecipeSmallCard
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun RecipesScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Recipes Screen", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(Screens.RecipeDetails.createRoute("123")) // Example recipe ID
        }) {
            Text("Go to Recipe Details")
        }
        RecipeSmallCard(recipeName = "Carbonade flamande", imageRes = R.drawable.carbonade2)
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreview() {
}