package com.groupe.gestionrecettes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [
    CategorieIngredient::class,
    Commente::class,
    Contenir::class,
    Continent::class,
    Etape::class,
    IconeCategorie::class,
    Illustrer::class,
    Image::class,
    Ingredient::class,
    IngredientDetails::class,
    ListeCourse::class,
    Pays::class,
    Presenter::class,
    Recette::class,
    TypeEtape::class,
    TypeRecette::class,
    UniteMesure::class,
    Utilisateur::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categorieIngredientDao(): CategorieIngredientDao
    abstract fun commenteDao(): CommenteDao
    abstract fun contenirDao(): ContenirDao
    abstract fun continentDao(): ContinentDao
    abstract fun etapeDao(): EtapeDao
    abstract fun iconeCategorieDao(): IconeCategorieDao
    abstract fun illustrerDao(): IllustrerDao
    abstract fun imageDao(): ImageDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun ingredientDetailsDao(): IngredientDetailsDao
    abstract fun listeCourseDao(): ListeCourseDao
    abstract fun paysDao(): PaysDao
    abstract fun presenterDao(): PresenterDao
    abstract fun recetteDao(): RecetteDao
    abstract fun typeEtapeDao(): TypeEtapeDao
    abstract fun typeRecetteDao(): TypeRecetteDao
    abstract fun uniteMesureDao(): UniteMesureDao
    abstract fun utilisateurDao(): UtilisateurDao
}
