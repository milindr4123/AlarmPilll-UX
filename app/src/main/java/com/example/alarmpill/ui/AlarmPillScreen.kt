package com.example.alarmpill.ui

import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.alarmpill.R

@Composable
fun AlarmPillScreen(navController: NavController) {

    val berlinSansFB = FontFamily(Font(R.font.brlnsr)) // Asegúrate de que el nombre coincida con el archivo


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FBFF)), // Fondo de pantalla color claro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.alarm_pill), // Reemplazar con tu recurso de imagen
            contentDescription = "Logo de AlarmPill",
            modifier = Modifier.size(270.dp),
            contentScale = ContentScale.Fit
        )

        // Nombre de la app
        Row(modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)) {
            Text(
                text = "Alarm",
                fontSize = 59.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = berlinSansFB, // Aquí asignamos la fuente
                color = Color(0xFFFF6F61) // Color naranja
            )
            Text(
                text = "Pill",
                fontSize = 59.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = berlinSansFB, // Aquí asignamos la fuente
                color = Color(0xFF00516F) // Color azul
            )
        }

        Spacer(modifier = Modifier.height(50.dp)) // Ajustar el tamaño según lo necesites

        // Botón de Comenzar
        Button(
            onClick = { navController.navigate("options") }, // Navegar a la pantalla de opciones
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00516F)),
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(0.9f)
                .height(65.dp),
            shape = RoundedCornerShape(17.dp)
        ) {

            Text(
                text = "¡Comencemos!",
                fontSize = 45.sp,
                color = Color.White,
                fontFamily = berlinSansFB // Aquí asignamos la fuente
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlarmPillScreen() {
    // Para el preview, no necesitas un NavController, por lo que puedes omitirlo
    AlarmPillScreen(navController = rememberNavController()) // Solo para mostrar en preview, si estás usando navController en tu proyecto
}

