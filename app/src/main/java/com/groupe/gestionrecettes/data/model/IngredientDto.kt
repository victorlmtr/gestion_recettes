package com.groupe.gestionrecettes.data.model

data class IngredientDto(
    val id: Int,
    val libIngredient: String,
    val categorieIngredient: IngredientCategoryDto
)