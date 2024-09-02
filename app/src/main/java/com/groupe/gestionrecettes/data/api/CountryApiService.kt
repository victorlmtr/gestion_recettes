package com.groupe.gestionrecettes.data.api

import retrofit2.http.GET

interface CountryApiService {
    @GET("/api/countries")
    suspend fun getCountries(): List<Country>
}

data class Country(
    val id: Int,
    val libPays: String,
    val idContinent: Continent
)

data class Continent(
    val id: Int,
    val libContinent: String
)