package com.novacenter.app.ui.turnos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.novacenter.app.databinding.ItemTurnoBinding
import com.novacenter.app.model.Turno

class TurnoAdapter(private val lista: List<Turno>) : RecyclerView.Adapter<TurnoAdapter.TurnoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurnoViewHolder {
        val binding = ItemTurnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TurnoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TurnoViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    inner class TurnoViewHolder(private val binding: ItemTurnoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(turno: Turno) {
            binding.tvFechaHora.text = "${turno.fecha} - ${turno.hora}"
            binding.tvMedico.text = "${turno.medico} - ${turno.especialidad}"
        }
    }
}
