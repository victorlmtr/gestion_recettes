package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.R

    fun mapRecetteToRecipe(recette: Recette): Recipe {
        return Recipe(
            id = recette.id_recette,
            name = recette.nomRecette,
            imageRes = getImageResource(recette.idTypeRecette),  // Assume this function gets the correct image resource
            chipLabel1 = getTypeLabel(recette.idTypeRecette),    // Assume this function gets the type label
            chipLabel2 = getCountryLabel(recette.idPays),        // Assume this function gets the country label
            chipIcon1 = getIconResource(recette.idTypeRecette),  // Assume this function gets the correct icon resource
            length = "${recette.tempsPreparation + recette.tempsCuisson} min",
            userCount = 100,  // Placeholder value
            rating = 4.5f,    // Placeholder value
            badgeCount = 5,    // Placeholder value
            description = "loul"
        )
    }

    // Placeholder functions for illustration
    fun getImageResource(typeId: Int): Int {
        // Return appropriate image resource based on typeId
        return R.drawable.chana2
    }

    fun getTypeLabel(typeId: Int): String {
        // Return appropriate type label based on typeId
        return "Type"
    }

    fun getCountryLabel(countryId: Int): String {
        // Return appropriate country label based on countryId
        return "Country"
    }

    fun getIconResource(typeId: Int): Int {
        // Return appropriate icon resource based on typeId
        return R.drawable.chicken
    }
