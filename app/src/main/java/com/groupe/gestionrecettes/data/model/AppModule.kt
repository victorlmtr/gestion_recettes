package com.groupe.gestionrecettes.data.model

import android.content.Context
import com.groupe.gestionrecettes.data.api.*
import com.groupe.gestionrecettes.data.repository.IngredientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://victorl.xyz:8081/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRecetteApiService(retrofit: Retrofit): RecetteApiService {
        return retrofit.create(RecetteApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeTypeService(retrofit: Retrofit): RecipeTypeService {
        return retrofit.create(RecipeTypeService::class.java)
    }

    @Provides
    @Singleton
    fun provideIngredientApiService(retrofit: Retrofit): IngredientApiService {
        return retrofit.create(IngredientApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideIngredientCategoryApiService(retrofit: Retrofit): IngredientCategoryApiService {
        return retrofit.create(IngredientCategoryApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideIngredientRepository(
        ingredientApiService: IngredientApiService,
        ingredientCategoryApiService: IngredientCategoryApiService
    ): IngredientRepository {
        return IngredientRepository(ingredientApiService, ingredientCategoryApiService)
    }

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryApiService(retrofit: Retrofit): CountryApiService {
        return retrofit.create(CountryApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }

    @Provides
    @Singleton
    fun provideRecipeDietService(retrofit: Retrofit): RecipeDietService {
        return retrofit.create(RecipeDietService::class.java)
    }
}
