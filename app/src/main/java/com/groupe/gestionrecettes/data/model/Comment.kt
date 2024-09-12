package com.groupe.gestionrecettes.data.model

import java.util.Date

data class Comment(
    val idUtilisateur: UserDto,
    val noteAvis: Double,
    val commentaireAvis: String?,
    val dateCommentaire: Date,
)