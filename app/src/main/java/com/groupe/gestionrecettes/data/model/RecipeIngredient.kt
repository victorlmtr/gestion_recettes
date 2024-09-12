package com.groupe.gestionrecettes.data.model

data class RecipeIngredient(
    val ingredient: Ingredient,
    val ingredientRecette: IngredientRecette,
    val inPantry: Boolean,
)