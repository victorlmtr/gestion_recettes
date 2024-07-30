package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun ScreenPicker(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    TabRow(
        selectedTabIndex = options.indexOf(selectedOption),
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.padding(8.dp).background(MaterialTheme.colorScheme.primary)
    ) {
        options.forEach { option ->
            Tab(
                selected = option == selectedOption,
                onClick = { onOptionSelected(option) },
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BasicText(text = option)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                unselectedContentColor = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPickerPreview() {
    GestionRecettesTheme {
        var selectedScreen by remember { mutableStateOf("Liste de courses") }
        ScreenPicker(
            options = listOf("Liste de courses", "Garde-manger"),
            selectedOption = selectedScreen,
            onOptionSelected = { selectedScreen = it }
        )
    }
}
