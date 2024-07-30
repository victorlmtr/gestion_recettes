package com.groupe.gestionrecettes.data

data class Comment(
    val username: String,
    val starRating: Float,
    val comment: String?,
    val date: String
)