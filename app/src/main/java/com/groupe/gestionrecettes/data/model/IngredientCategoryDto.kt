package com.groupe.gestionrecettes.data.model

data class IngredientCategoryDto(
    val id: Int,
    val libIngredient: String,
    val iconeCategorie: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IngredientCategoryDto

        return iconeCategorie.contentEquals(other.iconeCategorie)
    }

    override fun hashCode(): Int {
        return iconeCategorie.contentHashCode()
    }
}