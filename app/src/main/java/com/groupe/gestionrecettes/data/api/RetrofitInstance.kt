package com.groupe.gestionrecettes.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.groupe.gestionrecettes.data.api.*

object RetrofitInstance {

    //http://10.0.2.2:8081/ for the emulator (localhost equivalent). use IPV4 laptop address for a physical device
    // http://192.168.120.82
    // home: http://192.168.1.21:8081/
    private const val BASE_URL = "http://192.168.1.21:8081/"


    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    internal val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val countryApi: CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
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

    val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }

    val recipeApiService: RecetteApiService by lazy {
        retrofit.create(RecetteApiService::class.java)
    }

}