package com.groupe.gestionrecettes.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun RecipeBigCard(
    recipeName: String,
    @DrawableRes imageRes: Int,
    chipLabel1: String,
    chipLabel2: String,
    chipIcon1: Int,
    recipeLength: String,
    userCount: Int,
    rating: Float,
    badgeCount: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),  // Increased height
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)  // Increased image height
                ) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    )
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
                    verticalArrangement = Arrangement.spacedBy(8.dp)  // Evenly space elements vertically
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
                        horizontalArrangement = Arrangement.SpaceAround,
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
    GestionRecettesTheme {
        RecipeBigCard(
            recipeName = "Carbonade flamande",
            imageRes = R.drawable.carbonade2,
            chipLabel1 = "Végétarien",
            chipLabel2 = "Bosnie-Herzégovine",
            chipIcon1 = R.drawable.beef,
            recipeLength = "1 h 30",
            userCount = 100,
            rating = 4.5f,
            badgeCount = 4
        )
    }
}
