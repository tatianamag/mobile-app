package com.novacenter.app.ui.contacto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.novacenter.app.R

class ContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        val nombre = findViewById<EditText>(R.id.inputNombre)
        val email = findViewById<EditText>(R.id.inputEmail)
        val mensaje = findViewById<EditText>(R.id.inputMensaje)
        val botonEnviar = findViewById<Button>(R.id.btnEnviar)

        botonEnviar.setOnClickListener {
            val mailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:novacentergoya@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Mensaje de contacto de ${nombre.text}")
                putExtra(Intent.EXTRA_TEXT,
                    "Nombre: ${nombre.text}\nEmail: ${email.text}\n\nMensaje:\n${mensaje.text}")
            }

            if (mailIntent.resolveActivity(packageManager) != null) {
                startActivity(mailIntent)
            } else {
                Toast.makeText(this, "No se pudo abrir el cliente de correo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
