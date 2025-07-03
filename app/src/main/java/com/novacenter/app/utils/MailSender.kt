package com.novacenter.app.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class MailSender(private val context: Context) {

    suspend fun enviarNuevoPassword(destinatario: String, nuevaPass: String) {
        val props = Properties().apply {
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.port", "587")
        }

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(
                    "novacentergoya@gmail.com",
                    "fxxttdjwreegzpqx"
                )
            }
        })

        try {
            withContext(Dispatchers.IO) {
                val message = MimeMessage(session).apply {
                    setFrom(InternetAddress("novacentergoya@gmail.com"))
                    setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario))
                    subject = "Nueva contraseña NovaCenter"
                    setText("Tu nueva contraseña es: $nuevaPass\nPor favor cámbiala después de ingresar.")
                }
                Transport.send(message)
            }

            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Correo enviado con éxito", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Ocurrió un error al enviar el correo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
