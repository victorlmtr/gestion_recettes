import com.groupe.gestionrecettes.R

data class IngredientCategory(
    val id: Int,
    val name: String,
    val iconResId: Int
)

val ingredientCategories = listOf(
    IngredientCategory(0, "Légumes", R.drawable.vegetables),
    IngredientCategory(1, "Légumes", R.drawable.vegetables),
    IngredientCategory(2, "Fruits", R.drawable.fruits),
    IngredientCategory(3, "Huiles", R.drawable.oil),
    IngredientCategory(4, "Épices", R.drawable.spices),
    IngredientCategory(5, "Herbes aromatiques", R.drawable.basil),
    IngredientCategory(6, "Sucre farine et levure", R.drawable.flour),
    IngredientCategory(7, "Produits laitiers et œufs", R.drawable.dairy),
    IngredientCategory(8, "Viande", R.drawable.meat),
    IngredientCategory(9, "Viande de porc", R.drawable.pork),
    IngredientCategory(10, "Viande de bœuf", R.drawable.beef),
    IngredientCategory(11, "Poulet", R.drawable.chicken),
    IngredientCategory(12, "Fruits de mer", R.drawable.shellfish),
    IngredientCategory(13, "Poisson", R.drawable.fish),
    IngredientCategory(14, "Riz et céréales", R.drawable.rice),
    IngredientCategory(15, "Pâtes", R.drawable.pasta),
    IngredientCategory(16, "Pain", R.drawable.bread),
    IngredientCategory(17, "Condiments et vinaigres", R.drawable.condiments),
    IngredientCategory(18, "Conserves", R.drawable.cannedgoods),
    IngredientCategory(19, "Bouillons et soupes", R.drawable.broth),
    IngredientCategory(20, "Chocolat et confiseries", R.drawable.chocolate),
    IngredientCategory(21, "Alcools", R.drawable.alcohol),
    IngredientCategory(22, "Graines et noix et arachides", R.drawable.nutshell),
    IngredientCategory(23, "Protéines végétales", R.drawable.meatalternatives),
    IngredientCategory(24, "Boissons et liquides", R.drawable.liquids),
    IngredientCategory(25, "Laits végétaux", R.drawable.oatmilk)
)