package com.example.practica07

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrarseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val usuarioEditText: EditText = findViewById(R.id.usuario)
        val passwordEditText: EditText = findViewById(R.id.password)
        val correoEditText: EditText = findViewById(R.id.correo)
        val edadEditText: EditText = findViewById(R.id.edad)
        val generoRadioGroup: RadioGroup = findViewById(R.id.radioGroupGenero)
        val registrarButton: Button = findViewById(R.id.btnReg)
        val btnRegresar: Button = findViewById(R.id.btnregresar)

        registrarButton.setOnClickListener {
            val usuario = usuarioEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val correo = correoEditText.text.toString().trim()
            val edadStr = edadEditText.text.toString().trim()
            val generoId = generoRadioGroup.checkedRadioButtonId

            // Validación de campos
            if (usuario.isEmpty() || password.isEmpty() || correo.isEmpty() || edadStr.isEmpty() || generoId == -1) {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val edad = edadStr.toIntOrNull()
            if (edad == null || edad <= 0) {
                Toast.makeText(this, "Ingresa una edad válida.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val genero = findViewById<RadioButton>(generoId).text.toString()

            if (Usuario.buscarUsuario(usuario) != null) {
                Toast.makeText(this, "El usuario ya existe, elige otro nombre.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nuevoUsuario = Usuario(usuario, password, correo, edad, genero)
            Usuario.agregarUsuario(nuevoUsuario)

            Toast.makeText(this, "Usuario registrado exitosamente.", Toast.LENGTH_SHORT).show()

            usuarioEditText.text.clear()
            passwordEditText.text.clear()
            correoEditText.text.clear()
            edadEditText.text.clear()
            generoRadioGroup.clearCheck()
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}
