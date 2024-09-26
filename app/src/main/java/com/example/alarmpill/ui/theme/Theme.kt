package com.example.alarmpill.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AlarmPillTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}
