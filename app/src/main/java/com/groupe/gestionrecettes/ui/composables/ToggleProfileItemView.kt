package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.data.ToggleProfileItem

@Composable
fun ToggleProfileItemView(item: ToggleProfileItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = item.title,
                style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Switch(
            checked = item.isChecked.value,
            onCheckedChange = { isChecked ->
                item.isChecked.value = isChecked
                item.onToggle()
            }
        )
    }
}

@Preview
@Composable
fun ToggleProfileItemPreview() {
    val isChecked = remember { mutableStateOf(false) }
    ToggleProfileItemView(
        item = ToggleProfileItem(
            title = "Mode sombre",
            icon = Icons.Default.DarkMode,
            isChecked = isChecked,
            onToggle = { /* Handle toggle */ }
        )
    )
}
