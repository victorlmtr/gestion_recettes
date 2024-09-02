package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.data.api.Country
import java.util.Date

data class Recipe(
    val id: Int,
    val name: String,
    val description: String,
    val difficultyRating: Int,
    val portions: Int,
    val remarks: String?,
    val datePublished: Date,
    val image: ByteArray?,
    val country: Country,
    val type: RecipeType,
    val diets: List<RecipeDiet>,
    val steps: List<Step>,
    val totalTime: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false

        return true
    }

    override fun hashCode(): Int {
        return image?.contentHashCode() ?: 0
    }
}