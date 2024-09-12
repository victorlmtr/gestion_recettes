package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.data.helpers.formatDurationToFrench
import com.groupe.gestionrecettes.data.model.Recipe

@Composable
fun RecipeHeader(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // First Row: Country and Type of Recipe
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp), // Slightly reduce vertical padding for compactness
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            UnselectableChip(recipe.idPays.libPays)
            UnselectableChipIcon(
                recipe.idTypeRecette.libTypeRecette,
                recipe.idTypeRecette.iconeTypeRecette
            )
            UnselectableChip(formatDurationToFrench(recipe.totalTime))
        }

        // Second Row: Regime Recettes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp), // Same padding as the first row
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            recipe.regimeRecettes.forEach { regimeRecette ->
                UnselectableChipIcon(
                    regimeRecette.libRegimeRecette,
                    regimeRecette.iconeRegimeRecette
                )
            }
        }
    }
}
