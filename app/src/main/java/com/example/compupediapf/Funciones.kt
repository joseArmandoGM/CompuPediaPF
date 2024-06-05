package com.example.compupediapf

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.compupediapf.model.CartasComponentes
import com.example.compupediapf.ui.theme.primaryLight

@Composable
fun BottomAppBar(navController: NavController) {
    return BottomAppBar(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Row( // Colocamos los botones dentro de un Row
            modifier = Modifier
                .fillMaxWidth()
                //.background(primaryLight) // Cambia este color según tus necesidades
                .weight(1f), // Ocupa todo el ancho y peso 1
            horizontalArrangement = Arrangement.Center // Alinea los elementos al centro
        )
        {
            Spacer(modifier = Modifier.weight(.1f))
            IconButton(onClick = { navController.navigate("menu") }) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Pantalla principal",
                    modifier = Modifier.size(36.dp)
                )
            }
            Spacer(modifier = Modifier.weight(.15f))
            IconButton(onClick = { navController.navigate("favoritos") }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Favoritos",
                    modifier = Modifier.size(36.dp)
                )
            }
            Spacer(modifier = Modifier.weight(.15f))
            IconButton(onClick = { navController.navigate("buscar") }) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier.size(36.dp)
                )
            }
            Spacer(modifier = Modifier.weight(.1f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavController, pantalla: String) {
    return TopAppBar(
        title = {
            Text(
                text = pantalla,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 16.dp)
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ButtonRow(
    @DrawableRes imagen: Int,
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
            painter = painterResource(id = imagen),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
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

@Composable
fun Componentes(
    navController: NavHostController,
    cartasComponentes: CartasComponentes,
    onFavoriteClick: (CartasComponentes) -> Unit,
    cartaTexto: String,
    modifier: Modifier = Modifier
) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Box {
                Image(
                    painter = when (cartaTexto) {
                        "especificaciones" -> painterResource(cartasComponentes.cartaImagen)
                        "laptopEscritorio" -> painterResource(cartasComponentes.cartaImagenLaptopEscritorio)
                        else -> painterResource(cartasComponentes.cartaImagen)
                    },
                    contentDescription = stringResource(cartasComponentes.cartaDescripcion),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                        onFavoriteClick(cartasComponentes)

                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .background(Color(0xFFD3D3D3), CircleShape)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.Gray
                    )
                }
            }
        }
        Text(
            text = stringResource(id = cartasComponentes.cartaTitulo),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = when (cartaTexto) {
                "especificaciones" -> stringResource(id = cartasComponentes.cartaEspecificacion)
                "laptopEscritorio" -> stringResource(id = cartasComponentes.cartaLaptopEscritorio)
                else -> stringResource(id = cartasComponentes.cartaDescripcion)// En caso de no coincidir con ningún texto
            },
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
