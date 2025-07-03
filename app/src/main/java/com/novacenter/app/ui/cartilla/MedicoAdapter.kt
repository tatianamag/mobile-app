package com.novacenter.app.ui.cartilla

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.novacenter.app.R
import com.novacenter.app.data.model.Medico

class MedicoAdapter(private val lista: List<Medico>) :
    RecyclerView.Adapter<MedicoAdapter.MedicoViewHolder>() {

    inner class MedicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNombre)
        val especialidad: TextView = itemView.findViewById(R.id.tvEspecialidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medico, parent, false)
        return MedicoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicoViewHolder, position: Int) {
        val medico = lista[position]
        holder.nombre.text = medico.nombre
        holder.especialidad.text = medico.especialidad
    }

    override fun getItemCount() = lista.size
}