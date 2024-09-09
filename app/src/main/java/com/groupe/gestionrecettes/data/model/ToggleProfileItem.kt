package com.groupe.gestionrecettes.data.model

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector

data class ToggleProfileItem(
    val title: String,
    val icon: ImageVector,
    val isChecked: MutableState<Boolean>,
    val onToggle: () -> Unit
)
