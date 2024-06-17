package com.groupe.gestionrecettes.ui.composables

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.groupe.gestionrecettes.ui.theme.GestionRecettesTheme


@Composable
fun CtaButton(label: String, onClickAction: () -> Unit) {
    GestionRecettesTheme {
        val interactionSource = remember {
            MutableInteractionSource()
        }
        val isPressed = interactionSource.collectIsPressedAsState()
        Button(
            onClick = onClickAction,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isPressed.value) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
                contentColor = if (isPressed.value) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onTertiaryContainer
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
    }

@Preview(showBackground = true)
@Composable
fun CtaButtonPreview() {
    CtaButton(label = "Connexion") {
        Log.d("onClick", "button clicked")
    }
}