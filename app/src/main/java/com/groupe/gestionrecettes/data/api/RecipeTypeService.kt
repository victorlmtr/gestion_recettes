package com.groupe.gestionrecettes.data.api

import com.groupe.gestionrecettes.data.model.RecipeType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeTypeService {
    @GET("/api/types")
    suspend fun getTypes(): List<RecipeType>
}