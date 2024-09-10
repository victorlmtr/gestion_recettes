package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun UnselectableChipIcon(
    label: String,
    iconRes: String, // Changed to String
    modifier: Modifier = Modifier
) {
    // Use Coil to load the image from the URL
    val painter: Painter = rememberAsyncImagePainter(model = iconRes)

    Row(
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(vertical = 8.dp)
            .wrapContentSize()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = label,
            modifier = Modifier.size(14.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun UnselectableChipIconPreview() {
    ScrontchTheme {
        // Example preview data. Replace with actual URL as needed.
        val dummyIconRes = "https://example.com/icon.png"  // Replace with an actual image URL

        UnselectableChipIcon(label = "Légumes", iconRes = dummyIconRes)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FilterChipIcon2Preview() {
    ScrontchTheme {
        var isVegetableChipSelected by remember { mutableStateOf(false) }
        val dummyIconRes = "https://images.victorl.xyz/type1.png"

        SelectableChipIcon(
            label = "Légumes",
            iconRes = dummyIconRes,
            selected = isVegetableChipSelected,
            onSelectedChange = { isVegetableChipSelected = it }
        )
    }
}
