package com.example.practica07.data

import com.example.practica07.Producto

object ListaDeseosManager {
    private val listaDeseos = mutableListOf<Producto>()

    fun agregarProductoALista(producto: Producto) {
        if (!listaDeseos.contains(producto)) {
            listaDeseos.add(producto)
        }
    }

    fun obtenerListaDeseos(): List<Producto> {
        return listaDeseos
    }

    fun eliminarProductoDeLista(producto: Producto) {
        listaDeseos.remove(producto)
    }

    fun vaciarLista() {
        listaDeseos.clear()
    }
}
