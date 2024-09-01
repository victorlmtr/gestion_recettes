package com.groupe.gestionrecettes.ui.theme

import androidx.compose.ui.text.googlefonts.GoogleFont
import com.groupe.gestionrecettes.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font

class FontProvider {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontName = GoogleFont("Bebas Neue")

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )
}