package com.groupe.gestionrecettes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorie_ingredient")
data class CategorieIngredient(
    @PrimaryKey(autoGenerate = true) val id_categorie_ingredient: Int,
    @ColumnInfo(name = "libelle_categorie_ingredient") val libelleCategorieIngredient: String,
    @ColumnInfo(name = "id_icone_categorie") val idIconeCategorie: Int
)

@Entity(tableName = "commente")
data class Commente(
    @PrimaryKey val id_utilisateur: Int,
    @ColumnInfo(name = "id_recette") val idRecette: Int,
    @ColumnInfo(name = "note_avis") val noteAvis: Int?,
    @ColumnInfo(name = "commentaire_avis") val commentaireAvis: String?,
    @ColumnInfo(name = "est_favori") val estFavori: Boolean?
)

@Entity(tableName = "contenir")
data class Contenir(
    @PrimaryKey val id_ingredient: Int,
    @ColumnInfo(name = "id_etape") val idEtape: Int,
    @ColumnInfo(name = "id_unite_mesure") val idUniteMesure: Int,
    @ColumnInfo(name = "id_ingredient_details") val idIngredientDetails: Int,
    @ColumnInfo(name = "est_facultatif") val estFacultatif: Boolean,
    @ColumnInfo(name = "quantite") val quantite: Float
)

@Entity(tableName = "continent")
data class Continent(
    @PrimaryKey(autoGenerate = true) val id_continent: Int,
    @ColumnInfo(name = "nom_continent") val nomContinent: String
)

@Entity(tableName = "etape")
data class Etape(
    @PrimaryKey(autoGenerate = true) val id_etape: Int,
    @ColumnInfo(name = "duree_etape") val dureeEtape: Int,
    @ColumnInfo(name = "instructions_etape") val instructionsEtape: String,
    @ColumnInfo(name = "id_recette") val idRecette: Int,
    @ColumnInfo(name = "id_type_etape") val idTypeEtape: Int?
)

@Entity(tableName = "icone_categorie")
data class IconeCategorie(
    @PrimaryKey(autoGenerate = true) val id_icone_categorie: Int,
    @ColumnInfo(name = "libelle_icone_categorie") val libelleIconeCategorie: String,
    @ColumnInfo(name = "blob_icon") val blobIcon: ByteArray,
    @ColumnInfo(name = "id_categorie_ingredient") val idCategorieIngredient: Int?
)

@Entity(primaryKeys = ["id_image", "id_recette"])
data class Illustrer(
    @ColumnInfo(name = "id_image") val idImage: Int,
    @ColumnInfo(name = "id_recette") val idRecette: Int
)

@Entity(tableName = "image")
data class Image(
    @PrimaryKey(autoGenerate = true) val id_image: Int,
    @ColumnInfo(name = "libelle_image") val libelleImage: String
)

@Entity(tableName = "ingredient")
data class Ingredient(
    @PrimaryKey(autoGenerate = true) val id_ingredient: Int,
    @ColumnInfo(name = "nom_ingredient") val nomIngredient: String,
    @ColumnInfo(name = "id_categorie_ingredient") val idCategorieIngredient: Int
)

@Entity(tableName = "ingredient_details")
data class IngredientDetails(
    @PrimaryKey(autoGenerate = true) val id_ingredient_details: Int,
    @ColumnInfo(name = "libelle_ingredient_details") val libelleIngredientDetails: String
)

@Entity(tableName = "liste_course")
data class ListeCourse(
    @PrimaryKey(autoGenerate = true) val id_liste_course: Int,
    @ColumnInfo(name = "id_utilisateur") val idUtilisateur: Int
)

@Entity(tableName = "pays")
data class Pays(
    @PrimaryKey(autoGenerate = true) val id_pays: Int,
    @ColumnInfo(name = "lib_pays") val libPays: String,
    @ColumnInfo(name = "id_continent") val idContinent: Int
)

@Entity(primaryKeys = ["id_image", "id_etape"])
data class Presenter(
    @ColumnInfo(name = "id_image") val idImage: Int,
    @ColumnInfo(name = "id_etape") val idEtape: Int
)

@Entity(tableName = "recette")
data class Recette(
    @PrimaryKey(autoGenerate = true) val id_recette: Int,
    @ColumnInfo(name = "nom_recette") val nomRecette: String,
    @ColumnInfo(name = "date_recette") val dateRecette: String,
    @ColumnInfo(name = "temps_preparation") val tempsPreparation: Int,
    @ColumnInfo(name = "temps_cuisson") val tempsCuisson: Int,
    @ColumnInfo(name = "id_type_recette") val idTypeRecette: Int,
    @ColumnInfo(name = "id_pays") val idPays: Int,
    @ColumnInfo(name = "id_createur") val idCreateur: Int
)

@Entity(tableName = "type_etape")
data class TypeEtape(
    @PrimaryKey(autoGenerate = true) val id_type_etape: Int,
    @ColumnInfo(name = "libelle_type_etape") val libelleTypeEtape: String
)

@Entity(tableName = "type_recette")
data class TypeRecette(
    @PrimaryKey(autoGenerate = true) val id_type_recette: Int,
    @ColumnInfo(name = "libelle_type_recette") val libelleTypeRecette: String
)

@Entity(tableName = "unite_mesure")
data class UniteMesure(
    @PrimaryKey(autoGenerate = true) val id_unite_mesure: Int,
    @ColumnInfo(name = "libelle_unite_mesure") val libelleUniteMesure: String
)

@Entity(tableName = "utilisateur")
data class Utilisateur(
    @PrimaryKey(autoGenerate = true) val id_utilisateur: Int,
    @ColumnInfo(name = "pseudo_utilisateur") val pseudoUtilisateur: String,
    @ColumnInfo(name = "email_utilisateur") val emailUtilisateur: String,
    @ColumnInfo(name = "password_utilisateur") val passwordUtilisateur: String,
    @ColumnInfo(name = "date_naissance_utilisateur") val dateNaissanceUtilisateur: String
)
