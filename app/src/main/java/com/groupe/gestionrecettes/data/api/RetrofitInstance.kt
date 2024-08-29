package com.groupe.gestionrecettes.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //http://10.0.2.2:8081/ for the emulator (localhost equivalent). use IPV4 laptop address for a physical device http://192.168.120.82
    private const val BASE_URL = "http://192.168.120.82:8081/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val countryApi: CountryApi by lazy {
        retrofit.create(CountryApi::class.java)
    }
    val ingredientApiService: IngredientApiService by lazy {
        retrofit.create(IngredientApiService::class.java)
    }
    val ingredientCategoryApiService: IngredientCategoryApiService by lazy {
        retrofit.create(IngredientCategoryApiService::class.java)
    }

    val authApiService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }

}