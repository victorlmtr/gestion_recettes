package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun Badge(
    count: Int,
    modifier: Modifier = Modifier
) {
    val badgeColor = when (count) {
        in 0..2 -> MaterialTheme.colorScheme.primary
        in 3..5 -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(badgeColor)
    ) {
        Text(
            text = count.toString(),
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BadgePreview() {
    ScrontchTheme {
        Badge(5)
    }
}