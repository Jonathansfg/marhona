package com.example.practica07.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practica07.Producto
import com.example.practica07.R
import com.example.practica07.data.CarritoManager
import com.example.practica07.data.ListaDeseosManager

class DetailFragment : Fragment() {

    private lateinit var producto: Producto
    private var tallaSeleccionada: String? = null
    private var colorSeleccionado: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        producto = arguments?.getSerializable("producto") as Producto

        val imagenProducto: ImageView = view.findViewById(R.id.imagenProducto)
        val nombreProducto: TextView = view.findViewById(R.id.nombreProducto)
        val descripcionProducto: TextView = view.findViewById(R.id.descripcionProducto)
        val precioProducto: TextView = view.findViewById(R.id.precioProducto)
        val spinnerTallas: Spinner = view.findViewById(R.id.spinnerTallas)
        val spinnerColores: Spinner = view.findViewById(R.id.spinnerColores)
        val btnAgregarAlCarrito: Button = view.findViewById(R.id.btnAgregarAlCarrito)
        val btnAñadirListaDeseos: Button = view.findViewById(R.id.btnAñadirListaDeseos)

        imagenProducto.setImageResource(producto.imagen)
        nombreProducto.text = producto.nombre
        descripcionProducto.text = producto.descripcion
        precioProducto.text = "$${producto.precio}"

        val tallasAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, producto.tallas)
        tallasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTallas.adapter = tallasAdapter

        spinnerTallas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tallaSeleccionada = producto.tallas[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val coloresAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, producto.colores)
        coloresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColores.adapter = coloresAdapter

        spinnerColores.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                colorSeleccionado = producto.colores[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnAgregarAlCarrito.setOnClickListener {
            if (tallaSeleccionada != null && colorSeleccionado != null) {
                producto.tallaSeleccionada = tallaSeleccionada
                producto.colorSeleccionado = colorSeleccionado

                // Agregar el producto al carrito
                CarritoManager.agregarProductoAlCarrito(producto)
                Toast.makeText(requireContext(), "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor selecciona una talla y un color", Toast.LENGTH_SHORT).show()
            }
        }

        btnAñadirListaDeseos.setOnClickListener {
            if (tallaSeleccionada != null && colorSeleccionado != null) {
                producto.tallaSeleccionada = tallaSeleccionada
                producto.colorSeleccionado = colorSeleccionado

                // Agregar el producto a la lista de deseos
                ListaDeseosManager.agregarProductoALista(producto)
                Toast.makeText(requireContext(), "Producto añadido a la lista de deseos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor selecciona una talla y un color", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
