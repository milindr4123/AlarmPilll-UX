package com.example.alarmpill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Start1Screen(navController: NavController) {
    var medicationName by remember { mutableStateOf("") }

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
                tint = Color(0xFF000000), // Negro más intenso (hexadecimal para negro puro)
                modifier = Modifier.size(48.dp) // Ajusta el tamaño del ícono
            )
        }


        // Espaciado en la parte superior
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp), // Reducir este valor para subir todo el contenido
            horizontalAlignment = Alignment.CenterHorizontally // Mantener la caja de texto centrada
        ) {
            Spacer(modifier = Modifier.height(10.dp)) // Ajustar el espaciado según lo necesites

            // Label para el TextField
            Text(
                text = "Ingrese el nombre de su \n medicamento.",
                fontSize = 18.sp,
                color = Color(0xFF00516F),
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp) // Ajustar el margen a la izquierda
                    .align(Alignment.Start) // Alinear el texto a la izquierda
            )

            Spacer(modifier = Modifier.height(60.dp)) // Ajustar el espaciado según lo necesites

            // Caja de texto sencilla
            OutlinedTextField(
                value = medicationName,
                onValueChange = { medicationName = it },
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Ajustar el tamaño a un 90% del ancho
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp), // Bordes más redondeados
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Color del borde enfocado
                    unfocusedBorderColor = Color.Gray, // Color del borde no enfocado
                    containerColor = Color.White // Color de fondo
                )
            )
        }

        Spacer(modifier = Modifier.height(304.dp)) // Ajustar este espaciado según sea necesario

        // Row para los botones de navegación
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center // Centrar los botones
        ) {
            // Botón de Atrás
            IconButton(
                onClick = { navController.navigate("options") }, // Navegar a la pantalla de opciones
                modifier = Modifier.size(58.dp) // Tamaño del botón
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Atrás",
                    tint = Color.Red,
                    modifier = Modifier.size(56.dp) // Tamaño del icono
                )
            }

            // Espacio entre los botones
            Spacer(modifier = Modifier.width(190.dp)) // Espacio entre las flechas

            // Botón de Adelante
            IconButton(
                onClick = { navController.navigate("welcome") }, // Navegar a la pantalla siguiente
                modifier = Modifier.size(58.dp) // Tamaño del botón
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Adelante",
                    tint = Color(0xFF016281), // Color personalizado
                    modifier = Modifier.size(56.dp) // Tamaño del icono
                )
            }
        }
    }
}
