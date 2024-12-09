package com.example.practica07.ui.carrito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.practica07.R
import com.example.practica07.data.CarritoManager
import android.content.Intent
import com.example.practica07.ui.pedido.PedidoActivity


class CarritoFragment : Fragment() {

    private lateinit var adapter: CarritoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var subtotalTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var btnProcederPago: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_carrito, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewCarrito)
        totalTextView = view.findViewById(R.id.textTotal)
        btnProcederPago = view.findViewById(R.id.btnProcederPago)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CarritoAdapter(CarritoManager.obtenerCarrito().toMutableList()) { productoId -> eliminarProductoDelCarrito(productoId)}
        recyclerView.adapter = adapter

        actualizarTotales()

        btnProcederPago.setOnClickListener {
            val intent = Intent(requireContext(), PedidoActivity::class.java)
            startActivity(intent)
        }

    }

    private fun eliminarProductoDelCarrito(productoId: Int) {
        val producto = CarritoManager.obtenerCarrito().find { it.id == productoId }
        if (producto != null) {
            CarritoManager.eliminarProductoDelCarrito(producto)
            adapter.actualizarDatos(CarritoManager.obtenerCarrito().toMutableList())
            actualizarTotales()
        }
    }

    private fun actualizarTotales() {
        val total = CarritoManager.calcularTotal()

        totalTextView.text = "Total: $${String.format("%.2f", total)}"
    }
}
