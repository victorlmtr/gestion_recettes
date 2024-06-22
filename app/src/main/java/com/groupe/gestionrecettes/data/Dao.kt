package com.groupe.gestionrecettes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CategorieIngredientDao {
    @Query("SELECT * FROM categorie_ingredient")
    fun getAll(): List<CategorieIngredient>

    @Insert
    fun insertAll(vararg categorieIngredients: CategorieIngredient)
}

@Dao
interface CommenteDao {
    @Query("SELECT * FROM commente")
    fun getAll(): List<Commente>

    @Insert
    fun insertAll(vararg commentes: Commente)
}

@Dao
interface ContenirDao {
    @Query("SELECT * FROM contenir")
    fun getAll(): List<Contenir>

    @Insert
    fun insertAll(vararg contenirs: Contenir)
}

@Dao
interface ContinentDao {
    @Query("SELECT * FROM continent")
    fun getAll(): List<Continent>

    @Insert
    fun insertAll(vararg continents: Continent)
}

@Dao
interface EtapeDao {
    @Query("SELECT * FROM etape")
    fun getAll(): List<Etape>

    @Insert
    fun insertAll(vararg etapes: Etape)
}

@Dao
interface IconeCategorieDao {
    @Query("SELECT * FROM icone_categorie")
    fun getAll(): List<IconeCategorie>

    @Insert
    fun insertAll(vararg iconeCategories: IconeCategorie)
}

@Dao
interface IllustrerDao {
    @Query("SELECT * FROM illustrer")
    fun getAll(): List<Illustrer>

    @Insert
    fun insertAll(vararg illustrers: Illustrer)
}

@Dao
interface ImageDao {
    @Query("SELECT * FROM image")
    fun getAll(): List<Image>

    @Insert
    fun insertAll(vararg images: Image)
}

@Dao
interface IngredientDao {
    @Query("SELECT * FROM ingredient")
    fun getAll(): List<Ingredient>

    @Insert
    fun insertAll(vararg ingredients: Ingredient)
}

@Dao
interface IngredientDetailsDao {
    @Query("SELECT * FROM ingredient_details")
    fun getAll(): List<IngredientDetails>

    @Insert
    fun insertAll(vararg ingredientDetails: IngredientDetails)
}

@Dao
interface ListeCourseDao {
    @Query("SELECT * FROM liste_course")
    fun getAll(): List<ListeCourse>

    @Insert
    fun insertAll(vararg listeCourses: ListeCourse)
}

@Dao
interface PaysDao {
    @Query("SELECT * FROM pays")
    fun getAll(): List<Pays>

    @Insert
    fun insertAll(vararg pays: Pays)
}

@Dao
interface PresenterDao {
    @Query("SELECT * FROM presenter")
    fun getAll(): List<Presenter>

    @Insert
    fun insertAll(vararg presenters: Presenter)
}

@Dao
interface RecetteDao {
    @Query("SELECT * FROM recette")
    fun getAll(): List<Recette>

    @Insert
    fun insertAll(vararg recettes: Recette)
}

@Dao
interface TypeEtapeDao {
    @Query("SELECT * FROM type_etape")
    fun getAll(): List<TypeEtape>

    @Insert
    fun insertAll(vararg typeEtapes: TypeEtape)
}

@Dao
interface TypeRecetteDao {
    @Query("SELECT * FROM type_recette")
    fun getAll(): List<TypeRecette>

    @Insert
    fun insertAll(vararg typeRecettes: TypeRecette)
}

@Dao
interface UniteMesureDao {
    @Query("SELECT * FROM unite_mesure")
    fun getAll(): List<UniteMesure>

    @Insert
    fun insertAll(vararg uniteMesures: UniteMesure)
}

@Dao
interface UtilisateurDao {
    @Query("SELECT * FROM utilisateur")
    fun getAll(): List<Utilisateur>

    @Insert
    fun insertAll(vararg utilisateurs: Utilisateur)
}
