package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.data.Recipe

@Composable
fun RecipeSmallCardClickable(recipe: Recipe, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(0.dp)
    ) {
        RecipeSmallCard(
            recipeName = recipe.name,
            imageRes = recipe.imageRes,
            chipLabel1 = recipe.category,
            chipLabel2 = recipe.country.name,
            chipIcon1 = recipe.categoryIcon,
            recipeLength = recipe.length,
            userCount = recipe.userCount,
            rating = recipe.rating,
            badgeCount = recipe.badgeCount
        )
    }
}