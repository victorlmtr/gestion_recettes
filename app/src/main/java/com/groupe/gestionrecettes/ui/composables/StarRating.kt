package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun StarRating(
    rating: Float,
    userCount: Int,
    modifier: Modifier = Modifier,
    starSize: Int = 24,
    filledColor: Color = MaterialTheme.colorScheme.primary,
    unfilledColor: Color = MaterialTheme.colorScheme.outline
) {
    val fullStars = rating.toInt()
    val hasHalfStar = rating % 1 != 0f
    val emptyStars = 5 - fullStars - if (hasHalfStar) 1 else 0

    Row(modifier = modifier) {
        // Filled stars
        repeat(fullStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Filled Star",
                tint = filledColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
        // Half star
        if (hasHalfStar) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.StarHalf,
                contentDescription = "Half Filled Star",
                tint = filledColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
        // Empty stars
        repeat(emptyStars) {
            Icon(
                imageVector = Icons.Filled.StarBorder,
                contentDescription = "Empty Star",
                tint = unfilledColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
        // User count text
        Text(
            text = "($userCount)",
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StarRatingPreview() {
    ScrontchTheme {
        StarRating(rating = 2.5f, userCount = 2)
    }
}