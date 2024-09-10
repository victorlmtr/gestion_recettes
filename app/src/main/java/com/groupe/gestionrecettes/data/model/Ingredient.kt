package com.groupe.gestionrecettes.data.model


data class Ingredient(
    val id: Int,
    val libIngredient: String,
    val categorieIngredient: IngredientCategory
)


data class IngredientCategory(
    val id: Int,
    val libCategorieIngredient: String,
    var iconeCategorie: String
)