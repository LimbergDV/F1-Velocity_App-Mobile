package com.limbergdv.f1_velocity_app.features.formula1.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // SECCIÓN 1: Escudería Campeón de constructores 2025
        Column {
            // Header con fondo oscuro
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = "\"La app de los apasionados\npor el Gran Circo\"",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Imagen de los 3 pilotos
            AsyncImage(
                model = "https://container-images-limbi.s3.us-east-1.amazonaws.com/pilots.png",
                contentDescription = "Pilotos F1",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(Color.Black),
                contentScale = ContentScale.Crop
            )

            // Sección blanca con información del equipo campeón
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Escudería Campeón de\nconstructores 2025",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Logo de McLaren
                AsyncImage(
                    model = "https://container-images-limbi.s3.us-east-1.amazonaws.com/Mclaren.png",
                    contentDescription = "Logo McLaren",
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "McLaren",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }

        // SECCIÓN 2: Piloto Campeón del mundo 2025
        Column {
            // Sección negra con info del piloto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(vertical = 24.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Piloto Campeón del\nmundo 2025",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Lando Norris",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Imagen de Lando Norris
            AsyncImage(
                model = "https://container-images-limbi.s3.us-east-1.amazonaws.com/Lando+Norris.png",
                contentDescription = "Lando Norris",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .background(Color.Black),
                contentScale = ContentScale.Fit
            )

            // Espaciado inferior blanco
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.White)
            )
        }
    }
}