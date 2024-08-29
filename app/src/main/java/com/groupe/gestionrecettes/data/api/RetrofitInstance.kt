package com.groupe.gestionrecettes.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "http://10.0.2.2:8081/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val countryApi: CountryApi by lazy {
        retrofit.create(CountryApi::class.java)
    }
    val ingredientApi: IngredientApi by lazy {
        retrofit.create(IngredientApi::class.java)
    }
    val categoryApi: CategoryApi by lazy {
        retrofit.create(CategoryApi::class.java)
    }

}