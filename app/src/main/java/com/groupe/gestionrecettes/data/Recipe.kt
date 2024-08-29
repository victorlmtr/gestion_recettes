package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.R
import oldIngredientCategories
import java.util.Date

data class Recipe(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val category: String,
    val country: String,
    val categoryIcon: Int,
    val length: String,
    val userCount: Int,
    val rating: Float,
    val badgeCount: Int,
    val description: String,
    val datePublished: Date,
    val difficultyRating: Int,
    val oldIngredients: List<OldIngredient>,
    val steps: List<Step>
)

val recipes = listOf(
    Recipe(
        id = 1,
        name = "Carbonade flamande",
        imageRes = R.drawable.carbonade2,
        category = "Bœuf",
        country = "Belgique",
        categoryIcon = R.drawable.beef,
        length = "1 h 30",
        userCount = 2,
        rating = 4.5f,
        badgeCount = 4,
        description = "Un plat typique de la cuisine flamande à base de bœuf, de lard, d'oignons et de bière brune.",
        datePublished = Date(),
        difficultyRating = 3,
        oldIngredients = listOf(
            OldIngredient(1, "Bœuf", oldIngredientCategories[0]),
            OldIngredient(2, "Lard", oldIngredientCategories[0]),
            OldIngredient(3, "Oignons", oldIngredientCategories[0])
        ),
        steps = listOf(
            Step(1, "15 min", "Couper le bœuf en morceaux."),
            Step(2, "10 min", "Faire revenir le lard et les oignons.", R.drawable.shakshouka_step2),
            Step(3, "1 h 5 min", "Ajouter le bœuf et la bière, laisser mijoter.", R.drawable.shakshouka_step3)
        )
    ),
    Recipe(
        id = 2,
        name = "Chana masala",
        imageRes = R.drawable.chana2,
        category = "Végétarien",
        country = "Inde",
        categoryIcon = R.drawable.vegetables,
        length = "45 min",
        userCount = 58,
        rating = 3.0f,
        badgeCount = 1,
        description = "Curry indien vegan et sans gluten à base de pois chiches, de tomates et de coriandre.",
        datePublished = Date(),
        difficultyRating = 2,
        oldIngredients = listOf(
            OldIngredient(4, "Pois chiches", oldIngredientCategories[0]),
            OldIngredient(5, "Tomates", oldIngredientCategories[0]),
            OldIngredient(6, "Coriandre", oldIngredientCategories[1])
        ),
        steps = listOf(
            Step(4, "10 min", "Faire tremper les pois chiches."),
            Step(5, "20 min", "Cuire les pois chiches avec les tomates et les épices.", R.drawable.shakshouka_step2),
            Step(6, "15 min", "Ajouter la coriandre et servir.", R.drawable.shakshouka_step4)
        )
    ),
    Recipe(
        id = 3,
        name = "Shakshouka",
        imageRes = R.drawable.shakshouka1,
        category = "Végétarien",
        country = "Tunisie",
        categoryIcon = R.drawable.vegetables,
        length = "1 h",
        userCount = 270,
        rating = 1.5f,
        badgeCount = 8,
        description = "Œufs pochés dans une sauce tomate épicée.",
        datePublished = Date(),
        difficultyRating = 2,
        oldIngredients = listOf(
            OldIngredient(7, "Œufs", oldIngredientCategories[1]),
            OldIngredient(8, "Tomates", oldIngredientCategories[0]),
            OldIngredient(9, "Poivrons", oldIngredientCategories[0])
        ),
        steps = listOf(
            Step(7, "10 min", "Couper les tomates et les poivrons."),
            Step(8, "20 min", "Faire revenir les légumes dans de l'huile.", R.drawable.shakshouka_step2),
            Step(9, "30 min", "Ajouter les œufs et cuire à feu doux.", R.drawable.shakshouka_step4)
        )
    )
)