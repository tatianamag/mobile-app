package com.novacenter.app.ui.turnos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.data.model.Turno
import com.novacenter.app.databinding.ActivityTurnosBinding
import com.novacenter.app.ui.turnos.adapter.TurnoAdapter

class TurnosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTurnosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaTurnos = listOf(
            Turno(1, 10, 2, 1, "2025-08-05 10:30", "Confirmado", "Consulta de control"),
            Turno(2, 11, 3, 2, "2025-08-06 09:00", "Pendiente", "Chequeo general"),
            Turno(3, 12, 1, 3, "2025-08-09 13:45", "Confirmado", "Dolor ocular")
        )

        binding.recyclerTurnos.apply {
            layoutManager = LinearLayoutManager(this@TurnosActivity)
            adapter = TurnoAdapter(listaTurnos)
        }
    }
}