package com.novacenter.app.ui.cartilla

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.novacenter.app.R
import com.novacenter.app.data.repository.MedicoRepository
import kotlinx.coroutines.launch

class CartillaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MedicoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartilla)

        recyclerView = findViewById(R.id.recyclerCartilla)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val repo = MedicoRepository(this)

        lifecycleScope.launch {
            try {
                val response = repo.obtenerMedicos()
                if (response.isSuccessful) {
                    val medicos = response.body() ?: emptyList()
                    adapter = MedicoAdapter(medicos)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(
                        this@CartillaActivity,
                        "Error del servidor: ${response.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@CartillaActivity,
                    "Error al conectar con el servidor: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}