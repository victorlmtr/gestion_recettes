package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun CommentCard(
    username: String,
    starRating: Float,
    comment: String?,
    commentDate: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = username,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = commentDate,
                    style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            StarRatingComment(rating = starRating)
            if (!comment.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = comment,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommentCardPreview() {
    GestionRecettesTheme {
        CommentCard(
            username = "John Doe",
            starRating = 4.0f,
            comment = "This is a great recipe! I really enjoyed it.",
            commentDate = "2024-06-25"
        )
    }
}
