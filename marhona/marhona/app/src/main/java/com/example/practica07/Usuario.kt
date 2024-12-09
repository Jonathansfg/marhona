package com.example.practica07

open class Usuario(
    val usuario: String,
    val password: String,
    val correo: String,
    val edad: Int,
    val genero: String
) {
    companion object {
        val listaUsuarios = mutableListOf<Usuario>()

        init {
            val usuarioDefault = Usuario(
                usuario = "Usuario",
                password = "12345",
                correo = "usuario@example.com",
                edad = 20,
                genero = "Hombre"
            )
            listaUsuarios.add(usuarioDefault)
        }

        fun agregarUsuario(usuario: Usuario) {
            listaUsuarios.add(usuario)
        }

        fun buscarUsuario(nombre: String): Usuario? {
            return listaUsuarios.find { it.usuario == nombre }
        }
    }
}