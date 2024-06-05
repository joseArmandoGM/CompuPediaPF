package com.example.compupediapf.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class CartasEspecificaciones(
    @StringRes val cartaTitulo: Int,
    @StringRes val cartaDescripcion: Int,
    @StringRes val cartaEspecificacion: Int,
    @StringRes val cartaLaptopEscritorio: Int,
    @DrawableRes val imageResourceId: Int
)