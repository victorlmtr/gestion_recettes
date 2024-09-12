package com.groupe.gestionrecettes.data.model

data class IngredientRecette(
    val idUniteMesure: UniteMesure,
    val idIngredientDetails: IngredientDetails,
    val estFacultatif: Boolean,
    val quantite: Double,
    val inPantry: Boolean
)

