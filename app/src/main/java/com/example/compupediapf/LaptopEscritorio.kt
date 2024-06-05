package com.example.compupediapf


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compupediapf.data.Datasource
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaptopEscritorio(navController: NavHostController, favoritosViewModel: FavoritosViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                navController = navController,
                stringResource(id = R.string.pantallaLaptopEscritorio),
            )
        },
        bottomBar = {
            BottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(Datasource().loadComponentes()) { componentes ->
                Componentes(
                    navController = navController,
                    cartasComponentes = componentes,
                    onFavoriteClick = { favoritosViewModel.agregarFavorito(it) },
                    modifier = Modifier.padding(8.dp),
                    cartaTexto = "laptopEscritorio"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LaptopEscritorioPreview() {
    LaptopEscritorio(
        navController = NavHostController(LocalContext.current),
        favoritosViewModel = FavoritosViewModel()
    )
}