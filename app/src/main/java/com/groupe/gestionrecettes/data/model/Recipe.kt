package com.groupe.gestionrecettes.data.model

import com.groupe.gestionrecettes.data.api.Country
import java.util.Date

data class Recipe(
    val id: Int,
    val libRecette: String,
    val descriptionRecette: String,
    val difficulteRecette: Int,
    val nombrePortion: Int,
    val remarqueRecette: String?,
    val datePublicationRecette: Date,
    val imageRecette: String?,
    val idPays: Country,
    val idTypeRecette: RecipeType,
    val regimeRecettes: List<RecipeDiet>,
    val etapes: List<Step>,
    val totalTime: String,
    val comments: List<Comment>
)