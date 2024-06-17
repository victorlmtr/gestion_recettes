package com.groupe.gestionrecettes.ui.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.composables.CtaButton
import com.groupe.gestionrecettes.ui.composables.PasswordTextField
import com.groupe.gestionrecettes.ui.composables.UserNameTextField
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    GestionRecettesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(R.drawable.icon_login),
                    contentDescription = "Login picture"
                )
                Text(
                    text = "Bienvenue !",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(vertical = 20.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Connectez vous à votre compte")

                UserNameTextField(userName = userName)
                PasswordTextField(password = password)
                CtaButton(label = "Connexion") {
                }
                Text(
                    text = "Mot de passe oublié ?",
                    modifier = Modifier.clickable { }
                )
                Spacer(
                    modifier = Modifier.height(25.dp)
                )
                Text(
                    text = "Première connexion ? ",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Créer un compte",
                    modifier = Modifier.clickable { }
                )
            }
        }
    }
}



