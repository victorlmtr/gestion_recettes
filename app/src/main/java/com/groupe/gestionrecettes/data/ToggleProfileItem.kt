package com.groupe.gestionrecettes.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector

data class ToggleProfileItem(
    val title: String,
    val icon: ImageVector,
    val isChecked: MutableState<Boolean>,
    val onToggle: () -> Unit
)
