package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.composables.RecipeSmallCard
import org.w3c.dom.Text

data class Recipe(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val chipLabel1: String,
    val chipLabel2: String,
    val chipIcon1: Int,
    val length: String,
    val userCount: Int,
    val rating: Float,
    val badgeCount: Int,
    val description: String
)

val recipes = listOf(
    Recipe(
        1,
        name = "Carbonade flamande",
        imageRes = R.drawable.carbonade2,
        chipLabel1 = "Bœuf",
        chipLabel2 = "Belgique",
        chipIcon1 = R.drawable.beef,
        length = "1 h 30",
        userCount = 2,
        rating = 4.5f,
        badgeCount = 4,
        description = "Un plat typique de la cuisine flamande à base de bœuf, de lard, d'oignons et de bière brune."
    ),
    Recipe(
        2,
name = "Chana masala",
imageRes = R.drawable.chana2,
chipLabel1 = "Végétarien",
chipLabel2 = "Inde",
chipIcon1 = R.drawable.vegetables,
length = "45 min",
userCount = 58,
rating = 3.0f,
badgeCount = 1,
        description = "Curry indien vegan et sans gluten à base de pois chiches, de tomates et de coriandre."
),
Recipe(
    3,
name = "Shakshouka",
imageRes = R.drawable.shakshouka1,
chipLabel1 = "Végétarien",
chipLabel2 = "Tunisie",
chipIcon1 = R.drawable.vegetables,
length = "1 h",
userCount = 270,
rating = 1.5f,
badgeCount = 8,
    description = "Œufs pochés dans une sauce tomate épicée."
),
        Recipe(
        0,
    name = "Shakshouka",
    imageRes = R.drawable.shakshouka1,
    chipLabel1 = "Végétarien",
    chipLabel2 = "Tunisie",
    chipIcon1 = R.drawable.vegetables,
    length = "1 h",
    userCount = 270,
    rating = 1.5f,
    badgeCount = 8,
            description = "Œufs pochés dans une sauce tomate épicée"
)
)