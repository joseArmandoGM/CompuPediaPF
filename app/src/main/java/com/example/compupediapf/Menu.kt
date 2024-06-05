package com.example.compupediapf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            BottomAppBar(navController = navController)
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
                        imagen = R.drawable.informacion,
                        titulo = "Información general",
                        descripcion = "Ayuda general sobre los componentes"
                    ) {
                        navController.navigate("informacion")
                    }
                    ButtonRow(
                        imagen = R.drawable.laptoppc,
                        titulo = "Laptop y escritorio",
                        descripcion = "Diferencias entre componentes de PC y laptops"
                    ) {
                        navController.navigate("laptopEscritorio")
                    }
                    ButtonRow(
                        imagen = R.drawable.specs,
                        titulo = "Especificaciones",
                        descripcion = "Muestra las caracteristicas de cada componente"
                    ) {
                        navController.navigate("especificaciones")
                    }
                }
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