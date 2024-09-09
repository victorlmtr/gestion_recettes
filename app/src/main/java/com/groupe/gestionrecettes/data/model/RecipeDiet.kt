package com.groupe.gestionrecettes.data.model

data class RecipeDiet(
    val id: Int,
    val libDiet: String,
    val iconeDiet: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeDiet

        if (id != other.id) return false
        if (libDiet != other.libDiet) return false
        if (!iconeDiet.contentEquals(other.iconeDiet)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + libDiet.hashCode()
        result = 31 * result + iconeDiet.contentHashCode()
        return result
    }
}
