package com.groupe.gestionrecettes.data

data class OldIngredient(
    val id: Int,
    val name: String,
    val category: OldIngredientCategory
)

val oldIngredients = listOf(
    OldIngredient(1, "Tomates", oldIngredientCategories[0]),
    OldIngredient(2, "Onion", oldIngredientCategories[0]),
    OldIngredient(3, "Huile d'olive", oldIngredientCategories[2])
)
