package com.groupe.gestionrecettes.data.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class UserDto(
    @SerializedName("id") val id: Int,
    @SerializedName("nomUtilisateur") val nomUtilisateur: String,
    @SerializedName("emailUtilisateur") val emailUtilisateur: String,
    @SerializedName("mdpUtilisateur") val mdpUtilisateur: String,
    @SerializedName("dateCreationUtilisateur") val dateCreationUtilisateur: String
)