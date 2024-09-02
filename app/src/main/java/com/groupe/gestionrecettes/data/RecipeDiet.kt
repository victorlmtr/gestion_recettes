package com.groupe.gestionrecettes.data

data class RecipeDiet(
    val id: Int,
    val libDiet: String,
    val iconeDiet: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeDiet

        return iconeDiet.contentEquals(other.iconeDiet)
    }

    override fun hashCode(): Int {
        return iconeDiet.contentHashCode()
    }
}
