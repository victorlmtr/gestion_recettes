package com.groupe.gestionrecettes.data.model

data class Comment(
    val idUtilisateur: String,
    val starRating: Float,
    val comment: String?,
    val date: String
)