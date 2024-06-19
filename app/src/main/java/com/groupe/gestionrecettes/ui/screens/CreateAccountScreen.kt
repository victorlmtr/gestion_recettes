package com.groupe.gestionrecettes.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Composable
fun CreateAccountScreen(context: Context) {
    GestionRecettesTheme {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Inscription", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Nom d'utilisateur*") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email*") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe*") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {

                    if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {

                        // Display a toast message

                        Toast.makeText(
                            context,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {

                        // Handle the signup logic here

                        Toast.makeText(context, "Inscription réussie", Toast.LENGTH_SHORT).show()

                    }

                },

                modifier = Modifier.align(Alignment.CenterHorizontally)

            ) {

                Text("Suivant")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen(LocalContext.current)
}