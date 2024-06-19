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
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp, end = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = recipeName,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    StarRating(rating = rating)

                    Row {
                        UnselectableChipIcon(
                            label = "Bœuf",
                            iconRes = R.drawable.beef,
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        UnselectableChip(
                            label = "Belgique",
                        )
                    }

                    UnselectableChipIcon(
                        label = "30 min",
                        iconRes = R.drawable.clock,
                    )
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
                .offset(x = (-8).dp, y = 8.dp)
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
            rating = 3.5f,
            badgeCount = 4
        )
    }
}