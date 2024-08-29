package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.R

data class Step(
    val id: Int,
    val length: String,
    val instructions: String,
    val imageRes: Int? = null
)

val steps = listOf(
    Step(1, "5 min", "Chop the tomatoes and onions."),
    Step(2, "10 min", "Heat olive oil in a pan and add the chopped onions.", R.drawable.shakshouka_step2),
    Step(3, "15 min", "Add tomatoes and cook until soft.", R.drawable.shakshouka_step3)
)