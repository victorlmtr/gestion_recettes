package com.groupe.gestionrecettes.ui.composables

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun SelectableChipIcon(
    label: String,
    iconRes: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit
) {
    val painter: Painter = rememberAsyncImagePainter(model = iconRes)

    FilterChip(
        selected = selected,
        onClick = { onSelectedChange(!selected) },
        label = { Text(label) },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Selected",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            {
                Icon(
                    painter = painter,
                    contentDescription = label,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FilterChipIconPreview() {
    ScrontchTheme {
        var isVegetableChipSelected by remember { mutableStateOf(false) }
        val dummyIconRes = "https://images.victorl.xyz/type1.jpg"

        SelectableChipIcon(
            label = "Légumes",
            iconRes = dummyIconRes,
            selected = isVegetableChipSelected,
            onSelectedChange = { isVegetableChipSelected = it }
        )
    }
}
