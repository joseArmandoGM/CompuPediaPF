package com.example.compupediapf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compupediapf.ui.theme.CompuPediaPFTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val favoritosViewModel: FavoritosViewModel = viewModel()
            CompuPediaPFTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController = navController, startDestination = "bienvenida") {
                        composable("bienvenida") {
                            Bienvenida(navController = navController)
                        }
                        composable("menu") {
                            Menu(navController = navController)
                        }
                        composable("abdominales") {
                            Informacion(navController = navController, favoritosViewModel)
                        }
                        composable("Brazos") {
                            Especificaciones(navController = navController, favoritosViewModel)
                        }
                        composable("Espalda") {
                            LaptopEscritorio(navController = navController, favoritosViewModel)
                        }
                        composable("favoritos") {
                            Favoritos(navController = navController, favoritosViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Bienvenida(navController: NavController, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.7f
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp) // Tamaño más pequeño del logo
                .padding(bottom = 10.dp) // Espacio superior
                .scale(
                    scaleX = 3f,
                    scaleY = 3f
                ) // Ajuste de la escala en X (horizontal) y Y (vertical)
        )
        Image(
            painter = painterResource(id = R.drawable.principal),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
        )
        Text(
            text = "Bienvenido a Compupedia",
            style = TextStyle(
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            ),
            modifier = Modifier.padding(25.dp)
        )
        Text(
            text = "Empieza a aprender sobre computadoras y sus componentes",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,

                ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate("menu")
            },
            modifier = Modifier
                .height(90.dp) // Ajustar la altura
                .width(300.dp) // Ajustar el ancho
                .align(Alignment.CenterHorizontally), // Centrar verticalmente


            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "EMPEZAR", fontSize = 38.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BienvenidaPreview() {
    CompuPediaPFTheme {
        Bienvenida(navController = rememberNavController())
    }
}