package com.example.alarmpill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alarmpill.ui.AlarmPillScreen
import com.example.alarmpill.ui.OptionsScreen
import com.example.alarmpill.ui.Start4Screen
import com.example.alarmpill.ui.theme.AlarmPillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmPillTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    // Pantalla de bienvenida
                    composable("welcome") {
                        AlarmPillScreen(navController)
                    }
                    // Nueva pantalla de opciones
                    composable("options") {
                        OptionsScreen(navController)
                    }
                    // Nueva pantalla de opciones
                    composable("inicio1") {
                        Start1Screen(navController)
                    }
                    // Nueva pantalla de opciones
                    composable("inicio2") {
                        Start2Screen(navController)
                    }
                    // Nueva pantalla de opciones
                    composable("inicio3") {
                        Start3Screen(navController)
                    }
                    // Nueva pantalla de opciones
                    composable("inicio4") {
                        Start4Screen(navController)
                    }
                }
            }
        }
    }
}
