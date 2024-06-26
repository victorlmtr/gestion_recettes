package com.groupe.gestionrecettes.data

import IngredientCategory
import com.groupe.gestionrecettes.R
import ingredientCategories
import java.util.Date

data class Recipe(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val category: String,
    val country: Country,
    val categoryIcon: Int,
    val length: String,
    val userCount: Int,
    val rating: Float,
    val badgeCount: Int,
    val description: String,
    val datePublished: Date,
    val difficultyRating: Int,
    val portions: Int,
    val ingredients: List<Ingredient>,
    val steps: List<Step>
)
data class Ingredient(
    val id: Int,
    val name: String,
    val category: IngredientCategory
)
data class Step(
    val id: Int,
    val category: StepCategory,
    val length: String,
    val instructions: String,
    val ingredients: List<Ingredient>,
    val imageRes: Int? = null
)

data class StepCategory(
    val id: Int,
    val name: String,
)

data class Continent(
    val id: Int,
    val name: String,
)

data class Country(
    val id: Int,
    val name: String,
    val continent: Continent
)

val continents = listOf(
    Continent(0, "Afrique"),
    Continent(1, "Europe"),
    Continent(2, "Asie"),
    Continent(3, "Amérique")
)

val countries = listOf(
    Country(0, "Tunisie", continents[0]),
    Country(1, "Inde", continents[2]),
    Country(2, "Belgique", continents[1]),
)

val ingredients = listOf(
    Ingredient(0, "Tomato", ingredientCategories[0]),
    Ingredient(2, "Onion", ingredientCategories[0]),
    Ingredient(3, "Olive Oil", ingredientCategories[2]),
    Ingredient(4, "Bœuf", ingredientCategories[0]),
    Ingredient(5, "Ail", ingredientCategories[2]),
    Ingredient(6, "Coriandre", ingredientCategories[2])
)

val stepCategories = listOf(
    StepCategory(0, "Faire dorer"),
    StepCategory(1, "Cuisson sous pression"),
    StepCategory(2, "Assaisonner et servir"),
    StepCategory(3, "Assaisonner et servir")
)

val steps = listOf(
    Step(0, stepCategories[0],"5 min", "Chop the tomatoes and onions.", listOf(ingredients[0], ingredients[1])),
    Step(1, stepCategories[1],"7 min", "Chop chop", listOf(ingredients[0], ingredients[1])),
    Step(2, stepCategories[1], "10 min", "Heat olive oil in a pan and add the chopped onions.", listOf(ingredients[1], ingredients[2]), R.drawable.shakshouka_step2),
    Step(3, stepCategories[2], "15 min", "Add tomatoes and cook until soft.", listOf(ingredients[0], ingredients[2]), R.drawable.shakshouka_step3)
)



val recipes = listOf(
    Recipe(
        id = 0,
        name = "Shakshouka",
        imageRes = R.drawable.shakshouka1,
        category = "Végétarien",
        country = countries[0],
        categoryIcon = R.drawable.vegetables,
        length = "1 h",
        userCount = 270,
        rating = 1.5f,
        badgeCount = 8,
        description = "Œufs pochés dans une sauce tomate épicée.",
        datePublished = Date(),
        difficultyRating = 2,
        portions = 4,
        ingredients = listOf(
            ingredients[0], ingredients[2]
        ),
        steps = listOf(steps[0], steps[1])
    ),
    Recipe(
        id = 1,
        name = "Carbonade flamande",
        imageRes = R.drawable.carbonade2,
        category = "Bœuf",
        country = countries[2],
        categoryIcon = R.drawable.beef,
        length = "1 h 30",
        userCount = 2,
        rating = 4.5f,
        badgeCount = 4,
        description = "Un plat typique de la cuisine flamande à base de bœuf, de lard, d'oignons et de bière brune.",
        datePublished = Date(),
        difficultyRating = 3,
        portions = 4,
        ingredients = listOf(
            ingredients[0], ingredients[2]
        ),
        steps = listOf(steps[0], steps[1])
    ),
    Recipe(
        id = 2,
        name = "Chana masala",
        imageRes = R.drawable.chana2,
        category = "Végétarien",
        country = countries[1],
        categoryIcon = R.drawable.vegetables,
        length = "45 min",
        userCount = 58,
        rating = 3.0f,
        badgeCount = 1,
        description = "Curry indien vegan et sans gluten à base de pois chiches, de tomates et de coriandre.",
        datePublished = Date(),
        difficultyRating = 2,
        portions = 6,
        ingredients = listOf(
            ingredients[0], ingredients[2]
        ),
        steps = listOf(steps[1], steps[2])
    ),
    Recipe(
        id = 3,
        name = "Shakshouka",
        imageRes = R.drawable.shakshouka1,
        category = "Végétarien",
        country = countries[0],
        categoryIcon = R.drawable.vegetables,
        length = "1 h",
        userCount = 270,
        rating = 1.5f,
        badgeCount = 8,
        description = "Œufs pochés dans une sauce tomate épicée.",
        datePublished = Date(),
        difficultyRating = 2,
        portions = 4,
        ingredients = listOf(
            ingredients[0], ingredients[2]
        ),
        steps = listOf(steps[0], steps[1])
    )
)
