package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme

@Preview(showBackground = true)
@Composable
fun UsernameTextFieldPreview() {
    ScrontchTheme {
        val userName = remember { mutableStateOf("") }
        UserNameTextField(userName = userName)
    }
}

@Composable
fun UserNameTextField(userName: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier.padding(20.dp),
        value = userName.value,
        onValueChange = { newText ->
            userName.value = newText
        },
        placeholder = {
            Text(text = "Nom d'utilisateur")
        },
        label = {
            Text(text = "Nom d'utilisateur ")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
        )
    )
}
