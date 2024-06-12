package com.groupe.gestionrecettes.ui.composables

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasswordForgetButton(label: String, onClickAction: () -> Unit) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed = interactionSource.collectIsPressedAsState()
    Button(
        onClick = onClickAction,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed.value) Color(0xFF729C63) else Color(0xFF264B1C),
            contentColor = if (isPressed.value) Color.Black else Color.White,
            disabledContainerColor = Color(0xFF729C63),
            disabledContentColor = Color.Black
        ),
        interactionSource = interactionSource,
        enabled = true,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = label
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordForgetButtonPreview() {
    PasswordForgetButton(label = "Mot de passe oublié ?") {
        Log.d("onClick", "button clicked")
    }
}