package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.ui.composables.ExpandableCategory

@Composable
fun GroceryListScreen(navController: NavController) {
    // States to manage the expansion of both categories
    var ingredientsExpanded by remember { mutableStateOf(false) }
    var nonFoodItemsExpanded by remember { mutableStateOf(false) }

    // Sample data
    val ingredients = listOf("Tomates", "Pommes de terre", "Oignons", "Ail", "Carottes", "Poivron rouge")
    val nonFoodItems = listOf("Essuie-tout", "Liquide vaisselle", "Sacs congélation", "Sacs poubelle", "Piles AA", "Multiprise")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            ExpandableCategory(
                categoryName = "Alimentaire",
                items = ingredients,
                isExpanded = ingredientsExpanded,
                onExpandToggle = { ingredientsExpanded = !ingredientsExpanded }
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        }

        item {
            ExpandableCategory(
                categoryName = "Non-alimentaire",
                items = nonFoodItems,
                isExpanded = nonFoodItemsExpanded,
                onExpandToggle = { nonFoodItemsExpanded = !nonFoodItemsExpanded }
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GroceryListScreenPreview() {
    val navController = rememberNavController()
    GroceryListScreen(navController)
}
