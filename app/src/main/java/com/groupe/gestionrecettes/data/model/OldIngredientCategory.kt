package com.groupe.gestionrecettes.data.model

import com.groupe.gestionrecettes.R

data class OldIngredientCategory(
    val id: Int,
    val name: String,
    val iconResId: Int
)

val oldIngredientCategories = listOf(
    OldIngredientCategory(1, "Légumes", R.drawable.vegetables),
    OldIngredientCategory(2, "Fruits", R.drawable.fruits),
    OldIngredientCategory(3, "Huiles", R.drawable.oil),
    OldIngredientCategory(4, "Épices", R.drawable.spices),
    OldIngredientCategory(5, "Herbes aromatiques", R.drawable.basil),
    OldIngredientCategory(6, "Sucre farine et levure", R.drawable.flour),
    OldIngredientCategory(7, "Produits laitiers et œufs", R.drawable.dairy),
    OldIngredientCategory(8, "Viande", R.drawable.meat),
    OldIngredientCategory(9, "Viande de porc", R.drawable.pork),
    OldIngredientCategory(10, "Viande de bœuf", R.drawable.beef),
    OldIngredientCategory(11, "Poulet", R.drawable.chicken),
    OldIngredientCategory(12, "Fruits de mer", R.drawable.shellfish),
    OldIngredientCategory(13, "Poisson", R.drawable.fish),
    OldIngredientCategory(14, "Riz et céréales", R.drawable.rice),
    OldIngredientCategory(15, "Pâtes", R.drawable.pasta),
    OldIngredientCategory(16, "Pain", R.drawable.bread),
    OldIngredientCategory(17, "Condiments et vinaigres", R.drawable.condiments),
    OldIngredientCategory(18, "Conserves", R.drawable.cannedgoods),
    OldIngredientCategory(19, "Bouillons et soupes", R.drawable.broth),
    OldIngredientCategory(20, "Chocolat et confiseries", R.drawable.chocolate),
    OldIngredientCategory(21, "Alcools", R.drawable.alcohol),
    OldIngredientCategory(22, "Graines et noix et arachides", R.drawable.nutshell),
    OldIngredientCategory(23, "Protéines végétales", R.drawable.meatalternatives),
    OldIngredientCategory(24, "Boissons et liquides", R.drawable.liquids),
    OldIngredientCategory(25, "Laits végétaux", R.drawable.oatmilk)
)