package com.groupe.gestionrecettes.ui.composables
import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FilterChip
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun FilterChip(
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
fun FilterChipPreview() {
    GestionRecettesTheme {
        var isIndiaChipSelected by remember { mutableStateOf(false) }
        FilterChip(
            label = "Inde",
            selected = isIndiaChipSelected,
            onSelectedChange = { isIndiaChipSelected = it }
        ) }
}