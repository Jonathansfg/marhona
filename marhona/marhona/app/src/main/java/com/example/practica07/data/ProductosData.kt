package com.example.practica07.data

import com.example.practica07.Producto
import com.example.practica07.R


object ProductosData {
    private val productos = mutableListOf<Producto>()

    init {
        productos.add(
            Producto(
                id = 1,
                nombre = "Camisa Casual",
                descripcion = "Camisa casual de algodón, ideal para el día a día.",
                tallas = listOf("S", "M", "L", "XL"),
                precio = 199.99,
                colores = listOf("Rojo", "Azul", "Negro"),
                imagen = R.drawable.blusa
            )
        )
        productos.add(
            Producto(
                id = 2,
                nombre = "Pantalón de mezclilla",
                descripcion = "Pantalón de mezclilla cómodo y resistente.",
                tallas = listOf("M", "L", "XL"),
                precio = 299.99,
                colores = listOf("Azul", "Negro"),
                imagen = R.drawable.blusa2
            )
        )
        productos.add(
            Producto(
                id = 3,
                nombre = "Chaqueta de invierno",
                descripcion = "Chaqueta gruesa para clima frío, de material impermeable.",
                tallas = listOf("S", "M", "L"),
                precio = 499.99,
                colores = listOf("Verde", "Negro"),
                imagen = R.drawable.blusa3
            )
        )
    }

    // Función para agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    // Función para editar un producto por ID
    fun editarProducto(id: Int, nuevoProducto: Producto): Boolean {
        val indice = productos.indexOfFirst { it.id == id }
        return if (indice != -1) {
            productos[indice] = nuevoProducto
            true
        } else {
            false
        }
    }

    // Función para eliminar un producto por ID
    fun eliminarProducto(id: Int): Boolean {
        return productos.removeIf { it.id == id }
    }

    // Función para obtener todos los productos
    fun obtenerProductos(): List<Producto> {
        return productos
    }
}
