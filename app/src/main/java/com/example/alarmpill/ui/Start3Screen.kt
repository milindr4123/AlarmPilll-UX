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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Start3Screen(navController: NavController) {
    var selectedHour by remember { mutableStateOf("Hora") } // Valor por defecto "Hora"
    val hours = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12"
    ) // Opciones para seleccionar
    var expanded by remember { mutableStateOf(false) }
    var medicationQuantity by remember { mutableStateOf(12) } // Valor numérico

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
                    .padding(
                        bottom = 16.dp,
                        start = 16.dp
                    ) // Alinear el texto a la izquierda con un margen
                    .align(Alignment.Start) // Alinear el texto a la izquierda
            )

            Spacer(modifier = Modifier.height(33.dp)) // Ajustar el espaciado según lo necesites


            // Filas con los campos de texto ajustados
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 24.dp
                    ) // Márgenes para centrar sin usar Card
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically // Alinear verticalmente al centro
            ) {
                // Primera caja de texto para el número "12" (más ancho)
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
                                modifier = Modifier.size(16.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Incrementar",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(24.dp)
                                        .rotate(180f) // Rotación hacia arriba
                                )
                            }

                            // Flecha hacia abajo para decrementar
                            IconButton(
                                onClick = { if (medicationQuantity > 0) medicationQuantity-- },
                                modifier = Modifier.size(16.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Disminuir",
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(0.3f) // Hacer que el campo sea más ancho (60%)
                        .padding(end = 8.dp), // Espaciado entre los campos
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF00516F),
                        unfocusedBorderColor = Color.Gray,
                        containerColor = Color.White
                    )
                )

                // Segunda caja de texto para seleccionar "Hora" (más angosto)
                OutlinedTextField(
                    value = selectedHour,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .weight(0.6f) // Hacer que el campo sea más estrecho (40%)
                        .padding(start = 8.dp), // Espaciado entre los campos
                    shape = RoundedCornerShape(16.dp),
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Mostrar menú desplegable",
                                modifier = Modifier.size(16.dp) // Tamaño del icono ajustado
                            )
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF00516F),
                        unfocusedBorderColor = Color.Gray,
                        containerColor = Color.White
                    )
                )

                // Menú desplegable para la selección de la hora
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    hours.forEach { hour ->
                        DropdownMenuItem(
                            text = { Text(hour) },
                            onClick = {
                                selectedHour = hour // Actualizar el valor seleccionado
                                expanded = false // Cerrar el menú
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(291.dp)) // Ajustar este espaciado según sea necesario

            // Row para los botones de navegación
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center // Centrar los botones
            ) {
                // Botón de Atrás
                IconButton(
                    onClick = { navController.navigate("inicio2") }, // Navegar a la pantalla de opciones
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
                    onClick = { navController.navigate("inicio4") }, // Navegar a la pantalla siguiente
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
}
