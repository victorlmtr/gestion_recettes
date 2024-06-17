package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.R

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    val password = remember { mutableStateOf("") }
    PasswordTextField(
        password = password
    )
}


@Composable
fun PasswordTextField(password: MutableState<String>) {
    OutlinedTextField(
        modifier = Modifier.padding(20.dp),
        value = password.value,
        onValueChange = { newText ->
            password.value = newText
        },
        placeholder = {
            Text(text = "Mot de passe...")
        },
        label = {
            Text(text = "Mot de passe : ")
        }, visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(painter = painterResource(R.drawable.iconpassword),
                contentDescription = null,
                modifier = Modifier.size(28.dp))
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Green,
        )
    )
}

