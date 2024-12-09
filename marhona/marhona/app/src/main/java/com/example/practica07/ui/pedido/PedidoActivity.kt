package com.example.practica07.ui.pedido

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica07.R
import com.example.practica07.data.CarritoManager
import com.example.practica07.ui.carrito.CarritoAdapter

class PedidoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var spinnerMetodoPago: Spinner
    private lateinit var editTextDomicilio: EditText
    private lateinit var btnFinalizarPedido: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        recyclerView = findViewById(R.id.recyclerViewPedido)
        spinnerMetodoPago = findViewById(R.id.spinnerMetodosPago)
        editTextDomicilio = findViewById(R.id.editTextDomicilio)
        btnFinalizarPedido = findViewById(R.id.btnFinalizarPedido)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarritoAdapter(CarritoManager.obtenerCarrito().toMutableList()) {}

        val metodosPago = listOf("Tarjeta de Crédito", "Débito", "Paypal", "Efectivo")
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, metodosPago)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMetodoPago.adapter = adapterSpinner

        btnFinalizarPedido.setOnClickListener {
            val domicilio = editTextDomicilio.text.toString()
            if (domicilio.isBlank()) {
                Toast.makeText(this, "Por favor, ingresa un domicilio", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pedido realizado con éxito", Toast.LENGTH_SHORT).show()
                CarritoManager.vaciarCarrito()
                finish()
            }
        }
    }
}
