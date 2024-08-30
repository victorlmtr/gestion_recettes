package com.groupe.gestionrecettes.data.model

data class GroceryListDto(
    val id: Int,
    val idUtilisateur: Int,
    val ingredientDtoList: List<IngredientDto>,
    val nonConsommableDtoList: List<NonConsommableDto>
)