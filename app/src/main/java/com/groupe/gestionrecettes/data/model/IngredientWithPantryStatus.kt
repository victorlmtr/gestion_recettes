package com.groupe.gestionrecettes.data.model

data class IngredientWithPantryStatus(
    val ingredient: Ingredient,
    val inPantry: Boolean
)
