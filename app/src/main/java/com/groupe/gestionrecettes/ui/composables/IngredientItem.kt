package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IngredientItem(
    ingredient: String,
    qty: Double,
    unit: String,
    details: String,
    inPantry: Boolean,
    onAddToGroceryList: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Conditional formatting based on the "details" value
        val formattedDetails = if (details == "undefined") "" else ", $details"
        val formattedUnit = if (unit == "unité(s)") "" else " $unit"

        // Conditional formatting for quantity: Remove ".0" if the quantity is a whole number
        val formattedQty = if (qty % 1 == 0.0) qty.toInt().toString() else qty.toString()

        // Combine ingredient, formatted quantity, unit, and formatted details
        val ingredientText = "$ingredient, $formattedQty$formattedUnit$formattedDetails"

        Text(
            text = ingredientText,
            style = MaterialTheme.typography.bodyMedium
        )

        if (inPantry) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "In Pantry",
                tint = MaterialTheme.colorScheme.primary
            )
        } else {
            IconButton(onClick = onAddToGroceryList) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add to Grocery List",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        ingredient = "Tomates",
        qty = 2.0,
        unit = "kg",
        details = "coupées",
        inPantry = false,
        onAddToGroceryList = {}
    )
}
