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
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import java.io.ByteArrayInputStream
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap

@Composable
fun SelectableChipIcon(
    label: String,
    iconRes: ByteArray,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit
) {
    // Convert ByteArray to Bitmap and then to ImageBitmap
    val bitmap = BitmapFactory.decodeStream(ByteArrayInputStream(iconRes))
    val imageBitmap = bitmap?.asImageBitmap()

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
            imageBitmap?.let {
                {
                    Icon(
                        painter = BitmapPainter(it),
                        contentDescription = label,
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FilterChipIconPreview() {
    ScrontchTheme {
        var isVegetableChipSelected by remember { mutableStateOf(false) }

        // Example preview data. Replace with actual byte arrays as needed.
        val dummyIconRes = ByteArray(0)  // Replace with actual icon byte array

        SelectableChipIcon(
            label = "Légumes",
            iconRes = dummyIconRes,
            selected = isVegetableChipSelected,
            onSelectedChange = { isVegetableChipSelected = it }
        )
    }
}
