package com.example.practica07.ui.lista_deseos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica07.R
import com.example.practica07.data.ListaDeseosManager
import com.example.practica07.ui.carrito.CarritoAdapter

class ListaDeseosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarritoAdapter
    private lateinit var btnVaciarLista: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista_deseos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewListaDeseos)
        btnVaciarLista = view.findViewById(R.id.btnVaciarListaDeseos)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CarritoAdapter(ListaDeseosManager.obtenerListaDeseos().toMutableList()) { productoId ->
            eliminarProductoDeLista(productoId)
        }
        recyclerView.adapter = adapter

        btnVaciarLista.setOnClickListener {
            ListaDeseosManager.vaciarLista()
            adapter.notifyDataSetChanged()
        }
    }

    private fun eliminarProductoDeLista(productoId: Int) {
        val producto = ListaDeseosManager.obtenerListaDeseos().find { it.id == productoId }
        if (producto != null) {
            ListaDeseosManager.eliminarProductoDeLista(producto)
            adapter.notifyDataSetChanged()
        }
    }
}
