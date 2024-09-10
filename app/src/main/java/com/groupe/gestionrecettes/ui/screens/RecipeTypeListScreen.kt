package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.data.model.RecipeType
import com.groupe.gestionrecettes.data.viewmodel.RecipeTypeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTypeListScreen(viewModel: RecipeTypeViewModel = hiltViewModel()) {
    val recipeTypes by viewModel.recipeTypes.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .padding(16.dp) // Adjust padding as needed
    ) {
        recipeTypes.forEach { recipeType ->
            RecipeTypeItem(recipeType)
        }
    }
}

@Composable
fun RecipeTypeItem(recipeType: RecipeType) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Display recipe type icon using Coil to load from URL
        val painter = rememberAsyncImagePainter(model = recipeType.iconeType)

        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 8.dp) // Adjust size as needed
        )

        // Display recipe type name
        Text(
            text = recipeType.libTypeRecette,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
    }
}
