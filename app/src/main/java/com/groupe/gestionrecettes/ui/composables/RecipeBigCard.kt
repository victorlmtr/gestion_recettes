package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Composable
fun RecipeBigCard(
    recipeName: String,
    imageRes: String?,
    chipLabel1: String,
    chipLabel2: String,
    chipIcon1: ByteArray,
    recipeLength: String,
    userCount: Int,
    rating: Float,
    badgeCount: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = onClick),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                ) {
                    imageRes?.let { url ->
                        val painter = rememberAsyncImagePainter(url)
                        Image(
                            painter = painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .background(
                                Color.Black.copy(alpha = 0.5f)
                            )
                            .padding(8.dp)
                    ) {
                        Text(
                            text = recipeName,
                            style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StarRating(rating = rating, userCount)
                        RecipeLength(recipeLength)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        UnselectableChipIcon(
                            label = chipLabel1,
                            iconRes = chipIcon1,
                        )
                        UnselectableChip(
                            label = chipLabel2,
                        )
                    }
                }
            }
        }

        Badge(
            count = badgeCount,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 8.dp, y = (-4).dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeBigCardPreview() {
    ScrontchTheme {
        RecipeBigCard(
            recipeName = "Carbonade flamande",
            imageRes = "https://images.victorl.xyz/recipe1.jpg",
            chipLabel1 = "Végétarien",
            chipLabel2 = "Bosnie-Herzégovine",
            chipIcon1 = ByteArray(0),
            recipeLength = "1 h 30",
            userCount = 100,
            rating = 4.5f,
            badgeCount = 4,
            onClick = {}
        )
    }
}
