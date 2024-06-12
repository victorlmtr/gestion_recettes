package com.groupe.gestionrecettes.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmailTextField() {
    val text = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.padding(20.dp),
        value = text.value,
        onValueChange = { newText ->
            text.value = newText
        },
        placeholder = {
            Text(text = "Entrer votre mail...")
        },
        label = {
            Text(text = "Email : ")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Mail, contentDescription = null)
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Green,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun EmailTextFieldPreview() {
    EmailTextField()
}
