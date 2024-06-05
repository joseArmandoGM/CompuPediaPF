package com.example.compupediapf.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CartasComponentes(
    @StringRes val cartaTitulo: Int,
    @StringRes val cartaDescripcion: Int,
    @StringRes val cartaEspecificacion: Int,
    @StringRes val cartaLaptopEscritorio: Int,
    @DrawableRes val cartaImagen: Int
)
