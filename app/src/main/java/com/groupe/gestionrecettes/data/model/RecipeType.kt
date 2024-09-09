package com.groupe.gestionrecettes.data.model

data class RecipeType(
    val id: Int,
    val libType: String,
    val iconeType: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeType

        return iconeType.contentEquals(other.iconeType)
    }

    override fun hashCode(): Int {
        return iconeType.contentHashCode()
    }
}
