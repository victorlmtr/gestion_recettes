package com.groupe.gestionrecettes.ui.composables

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun RecipeSmallCard(
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
                .height(120.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp), // Increased left margin
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = recipeName,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Row(
                        modifier = Modifier.padding(top = 4.dp), // Added some space above
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StarRating(rating = rating, userCount)
                        Spacer(modifier = Modifier.width(4.dp)) // Added space between rating and length
                        RecipeLength(recipeLength)
                    }
                    Row {
                        UnselectableChipIcon(
                            label = chipLabel1,
                            iconRes = chipIcon1,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        UnselectableChip(
                            label = chipLabel2,
                        )

                    }
                }

                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                )
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
fun RecipeSmallCardPreview() {
    GestionRecettesTheme {
        RecipeSmallCard(
            recipeName = "Carbonade flamande",
            imageRes = R.drawable.carbonade2,
            chipLabel1 = "Végétarien",
            chipLabel2 = "Bosnie-Herzégovine",
            chipIcon1 = R.drawable.beef,
            recipeLength = "1 h 30",
            userCount = 100,
            rating = 4.5f,
            badgeCount = 4
        )
    }
}