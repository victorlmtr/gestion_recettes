package com.groupe.gestionrecettes.data.model

import java.time.LocalDate

data class UserDto(
    val id: Int,
    val nomUtilisateur: String,
    val emailUtilisateur: String,
    val mdpUtilisateur: String,
    val dateCreationUtilisateur: LocalDate
)