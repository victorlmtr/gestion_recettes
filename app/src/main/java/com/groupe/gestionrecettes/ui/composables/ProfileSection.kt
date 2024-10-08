package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.data.model.ProfileItem
import com.groupe.gestionrecettes.data.model.ToggleProfileItem

@Composable
fun ProfileSection(
    sectionName: String,
    items: List<Any>
) {
    Column {
        Text(
            text = sectionName,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        items.forEachIndexed { index, item ->
            when (item) {
                is ProfileItem -> ProfileListItem(item = item)
                is ToggleProfileItem -> ToggleProfileItemView(item = item)
            }
            if (index < items.size - 1) {
                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}
