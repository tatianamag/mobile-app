package com.novacenter.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.novacenter.app.databinding.SolicitudTurnoActivityBinding
import java.text.SimpleDateFormat
import java.util.*

class SolicitudTurnoActivity : AppCompatActivity() {

    private lateinit var binding: SolicitudTurnoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SolicitudTurnoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarAutoCompletes()
        configurarSelectorFecha()
        configurarBotonConfirmar()
    }

    private fun configurarAutoCompletes() {
        val especialidades = listOf("Clínico", "Cardiología", "Oftalmología", "Pediatría")
        val medicos = listOf("Dra. Gómez", "Dr. Ramírez", "Dra. López")
        val horarios = listOf("09:00 hs", "10:30 hs", "13:00 hs", "15:15 hs")

        binding.autoEspecialidad.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, especialidades))
        binding.autoMedico.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, medicos))
        binding.autoHorario.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, horarios))
    }

    private fun configurarSelectorFecha() {
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Seleccioná una fecha")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        binding.etFecha.setOnClickListener {
            picker.show(supportFragmentManager, "datePicker")
        }

        picker.addOnPositiveButtonClickListener { selection ->
            val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val fecha = formato.format(Date(selection))
            binding.etFecha.setText(fecha)
        }
    }

    private fun configurarBotonConfirmar() {
        binding.btnConfirmarTurno.setOnClickListener {
            val esp = binding.autoEspecialidad.text.toString().trim()
            val med = binding.autoMedico.text.toString().trim()
            val fecha = binding.etFecha.text.toString().trim()
            val hora = binding.autoHorario.text.toString().trim()

            if (esp.isEmpty() || med.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
                Toast.makeText(this, "Completá todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Acá podrías llamar al ViewModel o Retrofit para enviar el turno
                Toast.makeText(this, "Turno solicitado con éxito ✅", Toast.LENGTH_LONG).show()
                // finish() o redirigir a otra vista
            }
        }
    }
}
