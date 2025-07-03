package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.network.RetrofitInstance
import com.novacenter.app.data.network.UsuarioService

class UsuarioRepository(context: Context) {

    private val api: UsuarioService = RetrofitInstance
        .createRetrofit(context)
        .create(UsuarioService::class.java)

    suspend fun obtenerUsuarios(): List<Usuario> {
        return api.getUsuarios()
    }

    suspend fun obtenerUsuario(id: Int): Usuario {
        return api.getUsuario(id)
    }

    suspend fun agregarUsuario(usuario: Usuario): Usuario {
        return api.addUsuario(usuario)
    }

    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario {
        return api.updateUsuario(id, usuario)
    }

    suspend fun eliminarUsuario(id: Int) {
        api.deleteUsuario(id)
    }
}
