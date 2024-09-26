package com.example.alarmpill.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.alarmpill.R

@Composable
fun OptionsScreen(navController: NavController) { // Asegúrate de pasar el NavController
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0FBFF)), // Fondo de pantalla color claro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Mantener el contenido en la parte superior
    ) {
        // Botón de regresar (ícono de "X")
        IconButton(
            onClick = { navController.navigate("welcome") }, // Navegar hacia atrás
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
                .size(64.dp) // Ajusta el tamaño del botón
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Cerrar",
                tint = Color(0xFF00516F),
                modifier = Modifier.size(48.dp) // Ajusta el tamaño del ícono
            )
        }


        // Spacer para empujar el contenido hacia abajo
        Spacer(modifier = Modifier.height(8.dp)) // Ajusta la altura según sea necesario

        // Opción 1: Escribir recordatorio
        OptionItem(
            imageRes = R.drawable.voice, // Reemplazar con la imagen correcta
            description = "", // Proporcionar una descripción
            modifier = Modifier.padding(bottom = 45.dp),
            function = {
                navController.navigate("inicio1") // Navega a la pantalla inicio1
            }
        )

        // Opción 2: Grabar recordatorio
        OptionItem(
            imageRes = R.drawable.form, // Reemplazar con la imagen correcta
            description = "", // Proporcionar una descripción
            modifier = Modifier.padding(bottom = 45.dp),
            function = {
                navController.navigate("otra_ruta") // Asegúrate de usar una ruta válida
            }
        )
    }
}


@Composable
fun OptionItem(
    imageRes: Int,
    description: String,
    modifier: Modifier = Modifier,
    function: () -> Unit // Asegúrate de que este parámetro está presente
) {
    Box(
        modifier = modifier
            .size(290.dp) // Tamaño del Box
            .clickable { function() } // Ejecuta la función al hacer clic
            .background(Color.Transparent, shape = RoundedCornerShape(16.dp)), // Fondo transparente y forma redondeada
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize() // Asegura que el contenido ocupe todo el espacio del Box
                .padding(16.dp), // Espaciado interno
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = description,
                modifier = Modifier.size(250.dp), // Aumentar el tamaño de la imagen
                contentScale = ContentScale.Fit
            )
            Text(
                text = description,
                fontSize = 18.sp,
                color = Color(0xFF00516F),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}