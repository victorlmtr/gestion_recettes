package com.groupe.gestionrecettes.ui.composables
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.FilterChip
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun SelectableChip(
    label: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = { onSelectedChange(!selected) },
        label = { Text(label) },
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun IngredientChipPreview() {
    GestionRecettesTheme {
        var isTomatoChipSelected by remember { mutableStateOf(false) }
        SelectableChip(
            label = "Tomates",
            selected = isTomatoChipSelected,
            onSelectedChange = { isTomatoChipSelected = it }
        ) }
}