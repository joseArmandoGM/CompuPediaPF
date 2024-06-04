package com.example.compupediapf

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compupediapf.ui.theme.CompuPediaPFTheme


@Composable
fun Menu(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                IconButton(onClick = { navController.navigate("favoritos") }) {
                    Icon(
                        Icons.Sharp.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(45.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* Acción al hacer clic en el icono de casa */ }) {
                    Icon(
                        Icons.Sharp.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(45.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* Acción al hacer clic en el icono de calendario */ }) {
                    Icon(
                        Icons.Sharp.Search,
                        contentDescription = "Busqueda",
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fondo), // Asegúrate de tener una imagen en res/drawable
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp) // Tamaño más pequeño del logo
                        .padding(top = 16.dp) // Espacio superior
                        .scale(
                            scaleX = 3f,
                            scaleY = 3f
                        ) // Ajuste de la escala en X (horizontal) y Y (vertical)
                )
                Text(
                    text = "Menu principal",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp)) // Espacio entre el logo y los botones
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ButtonRow(
                        imageId = R.drawable.informacion,
                        titulo = "Información general",
                        descripcion = "Ayuda general sobre los componentes"
                    ) {
                        navController.navigate("abdominales")
                    }
                    ButtonRow(
                        imageId = R.drawable.laptoppc,
                        titulo = "Laptop y escritorio",
                        descripcion = "Diferencias entre componentes de PC y laptops"
                    ) {
                        navController.navigate("brazos")
                    }
                    ButtonRow(
                        imageId = R.drawable.specs,
                        titulo = "Especificaciones",
                        descripcion = "Muestra las caracteristicas de cada componente"
                    ) {
                        navController.navigate("espalda")
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonRow(
    @DrawableRes imageId: Int,
    titulo: String,
    descripcion: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)) // Esquinas redondeadas
            .background(Color(0xffa5c8ff))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = descripcion)
            Button(
                onClick = onClick,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally), // Centrar verticalmente
            ) {
                Text(text = "VER MÁS")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    CompuPediaPFTheme {
        // Usamos un NavHostController simulado para la vista previa
        Menu(navController = NavHostController(LocalContext.current))
    }
}