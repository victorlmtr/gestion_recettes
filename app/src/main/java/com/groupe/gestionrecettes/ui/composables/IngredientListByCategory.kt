package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.groupe.gestionrecettes.data.Ingredient
import com.groupe.gestionrecettes.data.IngredientCategory

@Composable
fun IngredientListByCategory(category: IngredientCategory, ingredients: List<Ingredient>) {
    var expanded by remember { mutableStateOf(false) }
    val visibleIngredients = if (expanded) ingredients else ingredients.take(8)

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberAsyncImagePainter(model = category.iconeCategorieIngredient),
                    contentDescription = category.libCategorieIngredient,
                    modifier = Modifier.size(32.dp).padding(end = 8.dp)
                )
                Text(
                    text = category.libCategorieIngredient,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) "Collapse" else "Expand",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 8.dp
            ) {
                visibleIngredients.forEach { ingredient ->
                    var selected by remember { mutableStateOf(false) }
                    SelectableChip(
                        label = ingredient.libIngredient,
                        selected = selected,
                        onSelectedChange = { selected = it }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientListByCategoryPreview() {
    val category = IngredientCategory(
        id = 1,
        libCategorieIngredient = "Légumes",
        iconeCategorieIngredient = "http://10.0.2.2:8081/api/ingredient-categories/1/icon"
    )
    val ingredients = listOf(
        Ingredient(id = 1, libIngredient = "Ail", categorieIngredient = category),
        Ingredient(id = 2, libIngredient = "Oignon", categorieIngredient = category),
        Ingredient(id = 3, libIngredient = "Carotte", categorieIngredient = category),
        Ingredient(id = 4, libIngredient = "Pomme de terre", categorieIngredient = category),
        Ingredient(id = 5, libIngredient = "Tomate", categorieIngredient = category),
        Ingredient(id = 6, libIngredient = "Concombre", categorieIngredient = category),
        Ingredient(id = 7, libIngredient = "Laitue", categorieIngredient = category),
        Ingredient(id = 8, libIngredient = "Poivron", categorieIngredient = category),
        Ingredient(id = 9, libIngredient = "Ail", categorieIngredient = category),
        Ingredient(id = 10, libIngredient = "Oignon", categorieIngredient = category),
        Ingredient(id = 11, libIngredient = "Carotte", categorieIngredient = category),
        Ingredient(id = 12, libIngredient = "Pomme de terre", categorieIngredient = category),
        Ingredient(id = 13, libIngredient = "Tomate", categorieIngredient = category),
        Ingredient(id = 14, libIngredient = "Concombre", categorieIngredient = category),
        Ingredient(id = 15, libIngredient = "Laitue", categorieIngredient = category),
        Ingredient(id = 16, libIngredient = "Poivron", categorieIngredient = category)
    )
    IngredientListByCategory(category = category, ingredients = ingredients)
}
