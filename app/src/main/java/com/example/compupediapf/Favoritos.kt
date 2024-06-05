package com.example.compupediapf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.compupediapf.model.CartasComponentes

// Favoritos.kt
class FavoritosViewModel : ViewModel() {
    val favoritos = mutableStateListOf<Any>()

    fun agregarFavorito(carta: Any) {
        if (!favoritos.contains(carta)) {
            favoritos.add(carta)
        }
    }

    fun eliminarFavorito(carta: Any) {
        favoritos.remove(carta)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favoritos(navController: NavHostController, favoritosViewModel: FavoritosViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                navController = navController,
                stringResource(id = R.string.pantallaFavoritos),
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
            items(favoritosViewModel.favoritos) { item ->
                when (item) {
                    is CartasComponentes -> Componentes(
                        navController = navController,
                        cartasComponentes = item,
                        onFavoriteClick = { favoritosViewModel.eliminarFavorito(it) },
                        modifier = Modifier.padding(8.dp),
                        cartaTexto = "descripcion"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritosPreview() {
    Favoritos(
        navController = NavHostController(LocalContext.current),
        favoritosViewModel = FavoritosViewModel()
    )
}
