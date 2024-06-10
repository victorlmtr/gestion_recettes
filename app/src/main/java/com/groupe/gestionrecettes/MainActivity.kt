package com.groupe.gestionrecettes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.composables.SearchBar
import com.groupe.gestionrecettes.ui.composables.BottomNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestionRecettesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun GestionRecettesAppPortrait() {
    GestionRecettesTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun GestionRecettesPortraitPreview() {
    GestionRecettesAppPortrait()
}
