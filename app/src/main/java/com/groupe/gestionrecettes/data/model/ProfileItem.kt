package com.groupe.gestionrecettes.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileItem(
    val title: String,
    val icon: ImageVector,
    val onClick: (() -> Unit)? = null
)