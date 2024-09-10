package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.groupe.gestionrecettes.data.viewmodel.CountryViewModel

@Composable
fun CountryList() {
    val viewModel: CountryViewModel = hiltViewModel()
    val countries by viewModel.countries.observeAsState(emptyList())
    val error by viewModel.error.observeAsState(null)
    val loading by viewModel.loading.observeAsState(false)

    if (loading) {
        CircularProgressIndicator()
    } else if (error != null) {
        Text(text = error!!)
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(countries) { country ->
                Text(
                    text = "${country.libPays} (${country.idContinent.libContinent})",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}