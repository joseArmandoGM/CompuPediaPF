package com.example.compupediapf.data

import com.example.compupediapf.R
import com.example.compupediapf.model.CartasComponentes

class Datasource {
    fun loadComponentes(): List<CartasComponentes> {
        return listOf<CartasComponentes>(
            CartasComponentes(
                "CPU",
                R.string.CPU_titulo,
                R.string.CPU_descripcion,
                R.string.CPU_especificaciones,
                R.string.CPU_laptopescritorio,
                R.drawable.cpu,
                R.drawable.cpu_laptopescritorio
            ),
            CartasComponentes(
                "RAM",
                R.string.RAM_titulo,
                R.string.RAM_descripcion,
                R.string.RAM_especificaciones,
                R.string.RAM_laptopescritorio,
                R.drawable.ram,
                R.drawable.ram_laptopescritorio
            ),
            CartasComponentes(
                "GPU",
                R.string.GPU_titulo,
                R.string.GPU_descripcion,
                R.string.GPU_especificaciones,
                R.string.GPU_laptopescritorio,
                R.drawable.gpu,
                R.drawable.gpu_laptopescritorio
            ),
            CartasComponentes(
                "HDD",
                R.string.HDD_titulo,
                R.string.HDD_descripcion,
                R.string.HDD_especificaciones,
                R.string.HDD_laptopescritorio,
                R.drawable.hdd,
                R.drawable.hdd_laptopescritorio
            ),
            CartasComponentes(
                "Wi-Fi",
                R.string.WIFI_titulo,
                R.string.WIFI_descripcion,
                R.string.WIFI_especificaciones,
                R.string.WIFI_laptopescritorio,
                R.drawable.wifi,
                R.drawable.wifi_laptopescritorio
            )
        )
    }

}