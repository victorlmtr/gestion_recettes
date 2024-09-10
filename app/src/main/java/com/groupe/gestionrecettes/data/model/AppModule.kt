package com.groupe.gestionrecettes.data.model

import android.content.Context
import com.groupe.gestionrecettes.data.api.AuthApiService
import com.groupe.gestionrecettes.data.api.RecetteApiService
import com.groupe.gestionrecettes.data.repository.RecipeRepository
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
    @Provides
    fun provideRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://victorl.xyz:8081/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }

    @Provides
    @Singleton
    fun provideRecetteApiService(retrofit: Retrofit): RecetteApiService {
        return retrofit.create(RecetteApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(apiService: RecetteApiService): RecipeRepository {
        return RecipeRepository(apiService)
    }
}
