package com.example.practica07
import java.io.Serializable

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val tallas: List<String>,
    val precio: Double,
    val colores: List<String>,
    val imagen: Int,
    var tallaSeleccionada: String? = null,  // Añadir estos atributos
    var colorSeleccionado: String? = null   // Añadir estos atributos
) : Serializable



