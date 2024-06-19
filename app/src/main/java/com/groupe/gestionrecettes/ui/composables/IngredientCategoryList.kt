package com.groupe.gestionrecettes.ui.composables

import IngredientCategory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import ingredientCategories

@Composable
fun IngredientCategoryList(categories: List<IngredientCategory>) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        categories.forEach { category ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Image(
                    painter = painterResource(id = category.iconResId),
                    contentDescription = category.name,
                    modifier = Modifier.size(40.dp).padding(end = 8.dp)
                )
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIngredientCategoryList() {
    IngredientCategoryList(categories = ingredientCategories)
}