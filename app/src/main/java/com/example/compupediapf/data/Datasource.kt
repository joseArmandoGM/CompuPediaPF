package com.example.compupediapf.data

import com.example.compupediapf.R
import com.example.compupediapf.model.CartasComponentes
import com.example.compupediapf.model.CartasEspecificaciones
import com.example.compupediapf.model.CartasLaptopEscritorio

class Datasource {
    fun loadComponentes(): List<CartasComponentes> {
        return listOf<CartasComponentes>(
            CartasComponentes(
                R.string.RAM_titulo,
                R.string.RAM_descripcion,
                R.string.RAM_especificaciones,
                R.string.RAM_laptopescritorio,
                R.drawable.ram
            ),
            CartasComponentes(
                R.string.CPU_titulo,
                R.string.CPU_descripcion,
                R.string.CPU_especificaciones,
                R.string.CPU_laptopescritorio,
                R.drawable.cpu
            ),
            CartasComponentes(
                R.string.GPU_titulo,
                R.string.GPU_descripcion,
                R.string.GPU_especificaciones,
                R.string.GPU_laptopescritorio,
                R.drawable.gpu
            ),
            CartasComponentes(
                R.string.HDD_titulo,
                R.string.HDD_descripcion,
                R.string.HDD_especificaciones,
                R.string.HDD_laptopescritorio,
                R.drawable.hdd
            )
        )
    }

    /*
    fun loadEspecificaciones(): List<CartasEspecificaciones> {
        return listOf<CartasEspecificaciones>(
            CartasEspecificaciones(
                R.string.RAM_titulo,
                R.string.RAM_especificaciones,
                R.drawable.ram
            ),
            CartasEspecificaciones(
                R.string.CPU_titulo,
                R.string.CPU_especificaciones,
                R.drawable.cpu
            ),
            CartasEspecificaciones(
                R.string.GPU_titulo,
                R.string.GPU_especificaciones,
                R.drawable.gpu
            ),
            CartasEspecificaciones(
                R.string.HDD_titulo,
                R.string.HDD_especificaciones,
                R.drawable.hdd
            )
        )
    }

    fun loadLaptopEscritorio(): List<CartasLaptopEscritorio> {
        return listOf<CartasLaptopEscritorio>(
            CartasLaptopEscritorio(
                R.string.RAM_titulo,
                R.string.RAM_laptopescritorio,
                R.drawable.ram
            ),
            CartasLaptopEscritorio(
                R.string.CPU_titulo,
                R.string.CPU_laptopescritorio,
                R.drawable.cpu
            ),
            CartasLaptopEscritorio(
                R.string.GPU_titulo,
                R.string.GPU_laptopescritorio,
                R.drawable.gpu
            ),
            CartasLaptopEscritorio(
                R.string.HDD_titulo,
                R.string.HDD_laptopescritorio,
                R.drawable.hdd
            )
        )
    }*/
}