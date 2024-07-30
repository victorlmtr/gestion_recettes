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
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupe.gestionrecettes.data.api.Country
import com.groupe.gestionrecettes.data.api.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun CountryList() {
    val viewModel = CountryListViewModel()
    val countries by viewModel.countries.observeAsState(emptyList())
    val error by viewModel.error.observeAsState(null)
    val loading by viewModel.loading.observeAsState(false)

    if (loading) {
        // Display a loading indicator
        CircularProgressIndicator()
    } else if (error != null) {
        // Display an error message
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

class CountryListViewModel : ViewModel() {
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val countries = RetrofitInstance.countryApi.getCountries()
                _countries.value = countries
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}