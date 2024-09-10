package com.groupe.gestionrecettes.data.model

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
    val image: String?,
    val country: Country,
    val type: RecipeType,
    val diets: List<RecipeDiet>,
    val steps: List<Step>,
    val totalTime: String
)