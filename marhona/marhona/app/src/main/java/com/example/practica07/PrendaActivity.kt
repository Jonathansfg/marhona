/*package com.example.practica07

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PrendaActivity : AppCompatActivity() {
    private lateinit var descripcion : TextView
    private lateinit var precio : TextView
    private lateinit var imagen : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_detail)

        descripcion = findViewById(R.id.txtDescripcion)
        precio = findViewById(R.id.txtPrecio)
        imagen = findViewById(R.id.imageProd)

        val data = intent.extras

        val detalles : String?
        val costo : String?
        val num : Int?

        if(data != null) {
            detalles = data.getString("detalle")
            costo = data.getString("costo")
            num = data.getInt("accesorio")

            descripcion.text = "Descripcion del item:\n$detalles"
            precio.text = "Costo: $costo"

            when(num) {
                1 -> imagen.setImageResource(R.drawable.vestido)

            }

        }
    }
}*/