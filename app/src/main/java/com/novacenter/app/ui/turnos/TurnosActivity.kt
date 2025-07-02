package com.novacenter.app.ui.turnos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.novacenter.app.databinding.ActivityTurnosBinding
import com.novacenter.app.model.Turno
import com.novacenter.app.ui.turnos.adapter.TurnoAdapter

class TurnosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTurnosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaTurnos = listOf(
            Turno("Lunes 5/08", "10:30hs", "Dr. Pablo Rivas", "Oftalmología"),
            Turno("Martes 6/08", "09:00hs", "Dra. Sánchez", "Cardiología"),
            Turno("Viernes 9/08", "13:45hs", "Dr. Luján", "Clínico")
        )

        binding.recyclerTurnos.apply {
            layoutManager = LinearLayoutManager(this@TurnosActivity)
            adapter = TurnoAdapter(listaTurnos)
        }
    }
}
