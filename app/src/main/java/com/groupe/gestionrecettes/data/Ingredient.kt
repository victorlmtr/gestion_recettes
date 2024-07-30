package com.groupe.gestionrecettes.data

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val id: Int,
    val libIngredient: String,
    val categorieIngredient: IngredientCategory
)

@Serializable
data class IngredientCategory(
    val id: Int,
    val libCategorieIngredient: String,
    val iconeCategorieIngredient: String
)