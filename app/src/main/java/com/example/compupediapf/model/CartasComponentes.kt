package com.example.compupediapf.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CartasComponentes(
    val nombreComponente: String,
    @StringRes val cartaTitulo: Int,
    @StringRes val cartaDescripcion: Int,
    @StringRes val cartaEspecificacion: Int,
    @StringRes val cartaLaptopEscritorio: Int,
    @DrawableRes val cartaImagen: Int,
    @DrawableRes val cartaImagenLaptopEscritorio: Int
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$nombreComponente",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
