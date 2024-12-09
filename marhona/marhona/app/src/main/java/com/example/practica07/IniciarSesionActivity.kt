package com.example.practica07

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class IniciarSesionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciarsesion)

        val usuarioEditText: EditText = findViewById(R.id.txtusuario)
        val passwordEditText: EditText = findViewById(R.id.txtcontra)
        val iniciarSesionButton: Button = findViewById(R.id.btnIniciar)
        val registrarButton: Button = findViewById(R.id.btnRegistrar)

        iniciarSesionButton.setOnClickListener {
            val usuario = usuarioEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validación de campos
            if (usuario.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa ambos campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar credenciales
            val usuarioEncontrado = Usuario.buscarUsuario(usuario)
            if (usuarioEncontrado != null && usuarioEncontrado.password == password) {
                Toast.makeText(this, "Inicio de sesión exitoso. ¡Bienvenido, $usuario!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
            }
        }

        registrarButton.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
    }
}
