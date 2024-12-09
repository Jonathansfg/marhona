package com.example.practica07.ui.carrito

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica07.Producto
import com.example.practica07.R

class CarritoAdapter(
    private val carrito: MutableList<Producto>,
    private val onProductoEliminado: (Int) -> Unit
) : RecyclerView.Adapter<CarritoAdapter.CarritoViewHolder>() {

    inner class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagenProducto: ImageView = itemView.findViewById(R.id.imagenProductoCarrito)
        val nombreProducto: TextView = itemView.findViewById(R.id.nombreProductoCarrito)
        val precioProducto: TextView = itemView.findViewById(R.id.precioProductoCarrito)
        val tallaProducto: TextView = itemView.findViewById(R.id.tallaProductoCarrito)
        val colorProducto: TextView = itemView.findViewById(R.id.colorProductoCarrito)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminarProductoCarrito)

        fun bind(producto: Producto) {
            imagenProducto.setImageResource(producto.imagen)
            nombreProducto.text = producto.nombre
            precioProducto.text = "$${producto.precio}"
            tallaProducto.text = "Talla: ${producto.tallaSeleccionada ?: "No seleccionada"}"
            colorProducto.text = "Color: ${producto.colorSeleccionado ?: "No seleccionado"}"

            btnEliminar.setOnClickListener {
                onProductoEliminado(producto.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto_carrito, parent, false)
        return CarritoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val producto = carrito[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int = carrito.size

    fun actualizarDatos(nuevaLista: MutableList<Producto>) {
        carrito.clear()
        carrito.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}
