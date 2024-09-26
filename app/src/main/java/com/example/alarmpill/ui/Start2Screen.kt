package com.example.alarmpill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Start2Screen(navController: NavController) {
    var medicationQuantity by remember { mutableStateOf(12) } // Mantener un valor numérico
    var selectedPresentation by remember { mutableStateOf("Tableta") }

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

        // Espaciado en la parte superior
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp), // Reducir este valor para subir todo el contenido
            horizontalAlignment = Alignment.CenterHorizontally // Mantener la caja de texto centrada
        ) {
            Spacer(modifier = Modifier.height(10.dp)) // Ajustar el espaciado según lo necesites


            // Texto de descripción alineado a la izquierda
            Text(
                text = "Ingrese la cantidad total de  \n medicamento a tomar y su  \n presentación.",
                fontSize = 18.sp,
                color = Color(0xFF00516F),
                modifier = Modifier
                    .padding(bottom = 16.dp, start = 16.dp) // Alinear el texto a la izquierda con un margen
                    .align(Alignment.Start) // Alinear el texto a la izquierda
            )

            Spacer(modifier = Modifier.height(50.dp)) // Ajustar el espaciado según lo necesites

            // Caja de texto con flechas hacia arriba y abajo para aumentar/disminuir el valor
            OutlinedTextField(
                value = medicationQuantity.toString(),
                onValueChange = { newValue ->
                    newValue.toIntOrNull()?.let {
                        medicationQuantity = it
                    }
                },
                trailingIcon = {
                    Column {
                        // Flecha hacia arriba para incrementar
                        IconButton(
                            onClick = { medicationQuantity++ },
                            modifier = Modifier
                                .size(16.dp)
                                .rotate(180f) // Aplicamos la rotación de 180 grados
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Incrementar",
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        // Flecha hacia abajo para decrementar
                        IconButton(
                            onClick = {
                                if (medicationQuantity > 0) medicationQuantity--
                            },
                            modifier = Modifier.size(16.dp) // Tamaño del botón
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown, // Flecha hacia abajo
                                contentDescription = "Disminuir",
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp) // Tamaño de la flecha
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.3f) // Ajustar el tamaño
                    .padding(5.dp),
                shape = RoundedCornerShape(16.dp), // Bordes redondeados
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF00516F),
                    unfocusedBorderColor = Color.Gray,
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(66.dp)) // Ajustar este espaciado según sea necesario

            // Texto debajo del campo de entrada con línea
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = selectedPresentation,
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                // Línea debajo del texto
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .width(200.dp) // Ancho de la línea
                )
            }
        }

        Spacer(modifier = Modifier.height(200.dp)) // Ajustar este espaciado según sea necesario

        // Row para los botones de navegación
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center // Centrar los botones
        ) {
            // Botón de Atrás
            IconButton(
                onClick = { navController.navigate("inicio1") }, // Navegar a la pantalla de opciones
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
                onClick = { navController.navigate("inicio3") }, // Navegar a la pantalla siguiente
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
