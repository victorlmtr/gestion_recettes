package com.groupe.gestionrecettes.data.model

data class Step(
    val id: Int,
    val dureeEtape: String,
    val instructionsEtape: String,
    val imageEtape: String?,
    val idTypeEtape: StepType
)

data class StepType(
    val id: Int,
    val libTypeEtape: String
)