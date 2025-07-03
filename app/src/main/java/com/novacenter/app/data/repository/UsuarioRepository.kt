package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.network.RetrofitInstance

class UsuarioRepository {

    private val api = RetrofitInstance.usuarioService

    suspend fun obtenerUsuarios(): List<Usuario> {
        return api.getUsuarios()
    }

    private val api = RetrofitInstance.getRetrofit(context).create(com.novacenter.app.data.network.UsuarioService::class.java)

    suspend fun obtenerUsuarios(): List<Usuario> = api.getUsuarios()
    suspend fun obtenerUsuario(id: Int): Usuario = api.getUsuario(id)
    suspend fun agregarUsuario(usuario: Usuario): Usuario = api.addUsuario(usuario)
    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario = api.updateUsuario(id, usuario)
    suspend fun eliminarUsuario(id: Int) = api.deleteUsuario(id)
}

    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario {
        return api.updateUsuario(id, usuario)
    }

    suspend fun eliminarUsuario(id: Int) {
        api.deleteUsuario(id)
    }
}
