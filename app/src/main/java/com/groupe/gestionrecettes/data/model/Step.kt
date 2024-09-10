package com.groupe.gestionrecettes.data.model

data class Step(
    val id: Int,
    val length: String,
    val instructions: String,
    val imageRes: String?
)