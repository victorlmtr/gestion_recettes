package com.groupe.gestionrecettes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.groupe.gestionrecettes.R
import com.groupe.gestionrecettes.ui.composables.CtaButton
import com.groupe.gestionrecettes.ui.composables.PasswordTextField
import com.groupe.gestionrecettes.ui.composables.UserNameTextField
import com.groupe.gestionrecettes.ui.theme.ScrontchTheme
import com.groupe.gestionrecettes.data.model.Screens
import com.groupe.gestionrecettes.data.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    authViewModel: AuthViewModel = hiltViewModel()) {
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginState by authViewModel.loginState.collectAsState()

    ScrontchTheme {
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
                    text = "Bienvenue !",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.padding(vertical = 20.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Connectez-vous à votre compte")

                UserNameTextField(userName = userName)
                PasswordTextField(password = password)

                CtaButton(label = "Connexion") {
                    authViewModel.login(userName.value, password.value)
                }

                Spacer(modifier = Modifier.height(5.dp))

                when (loginState) {
                    is AuthViewModel.LoginState.Loading -> {
                        Text(text = "Chargement…")
                    }
                    is AuthViewModel.LoginState.Success -> {
                        navController.navigate(Screens.Home.route)
                    }
                    is AuthViewModel.LoginState.Error -> {
                        Text(text = "Erreur : ${(loginState as AuthViewModel.LoginState.Error).message}")
                    }
                    else -> Unit
                }

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "Mot de passe oublié ?",
                    modifier = Modifier.clickable { }
                )

                Spacer(modifier = Modifier.height(25.dp))

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

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}
