package com.example.practica07.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica07.Producto
import com.example.practica07.R
import com.example.practica07.data.ProductosData

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productosAdapter: ProductosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val productos = ProductosData.obtenerProductos()

        productosAdapter = ProductosAdapter(productos) { productoSeleccionado ->
            val bundle = Bundle().apply {
                putSerializable("producto", productoSeleccionado)
            }
            findNavController().navigate(R.id.action_galleryFragment_to_detailFragment, bundle)
        }

        recyclerView.adapter = productosAdapter
    }
}
