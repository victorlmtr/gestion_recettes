package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.ui.composables.ScreenPicker
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.viewmodel.IngredientViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.groupe.gestionrecettes.ui.composables.SearchBar


@Composable
fun PantryScreen(navController: NavController, viewModel: IngredientViewModel = hiltViewModel()) {
    var selectedScreen by remember { mutableStateOf("Liste de courses") }

    ScrontchTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                ScreenPicker(
                    options = listOf("Liste de courses", "Garde-manger"),
                    selectedOption = selectedScreen,
                    onOptionSelected = { selectedScreen = it }
                )
                SearchBar()
                when (selectedScreen) {
                    "Liste de courses" -> {
                        GroceryListScreen(navController)
                    }

                    "Garde-manger" -> {
                        PantryListScreen(viewModel)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    val navController = rememberNavController()
    val viewModel = IngredientViewModel()
    PantryScreen(navController, viewModel)
}
