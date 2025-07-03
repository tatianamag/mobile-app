package com.novacenter.app.ui.cartilla

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.novacenter.app.R
import com.novacenter.app.data.model.Medico

class CartillaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartilla)

        recyclerView = findViewById(R.id.recyclerCartilla)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val medicos = listOf(
            Medico("Dra. María López", "Pediatría", "Lunes a Viernes - 08:00 a 12:00"),
            Medico("Dr. Juan García", "Clínica médica", "Martes y Jueves - 15:00 a 18:00"),
            Medico("Dra. Sofía Ramírez", "Ginecología", "Miércoles - 10:00 a 13:00")
        )

        adapter = MedicoAdapter(medicos)
        recyclerView.adapter = adapter
    }
}
