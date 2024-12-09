package com.example.practica07.data

import com.example.practica07.Producto

object CarritoManager {
    private val carrito = mutableListOf<Producto>()

    fun agregarProductoAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    fun obtenerCarrito(): List<Producto> {
        return carrito
    }

    fun eliminarProductoDelCarrito(producto: Producto) {
        carrito.remove(producto)
    }

    fun calcularSubtotal(): Double {
        return carrito.sumOf { it.precio }
    }

    fun calcularTotal(): Double {
        // Ahora, el total es simplemente la suma de precios (igual al subtotal).
        return calcularSubtotal()
    }

    fun vaciarCarrito() {
        carrito.clear()
    }
}
