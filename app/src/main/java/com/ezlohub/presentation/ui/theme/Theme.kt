package com.ezlohub.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = grayBackground,
    onPrimary = textDark,
    secondary = whiteBackground,
    onSecondary = textLight,
    tertiary = appBar,
    onBackground = white
)

@Composable
fun EzloHubTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}