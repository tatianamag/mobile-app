package com.novacenter.app.ui.turnos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.novacenter.app.data.model.Turno
import com.novacenter.app.databinding.ItemTurnoBinding

class TurnoAdapter(private val lista: List<Turno>) :
    RecyclerView.Adapter<TurnoAdapter.TurnoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TurnoViewHolder {
        val binding = ItemTurnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TurnoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TurnoViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    inner class TurnoViewHolder(private val binding: ItemTurnoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(turno: Turno) {
            binding.tvFechaHora.text = turno.fecha_y_hora
            binding.tvMedico.text = "Médico ID: ${turno.id_medico} | Estado: ${turno.estado}"
        }
    }
}