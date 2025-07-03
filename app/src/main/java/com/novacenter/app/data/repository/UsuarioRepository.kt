package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.network.RetrofitInstance
import com.novacenter.app.data.network.UsuarioService

class UsuarioRepository(private val context: Context) {

    private val api: UsuarioService by lazy {
        RetrofitInstance.getRetrofit(context).create(UsuarioService::class.java)
    }

    suspend fun obtenerUsuarios(): List<Usuario> = api.getUsuarios()
    suspend fun obtenerUsuario(id: Int): Usuario = api.getUsuario(id)
    suspend fun agregarUsuario(usuario: Usuario): Usuario = api.addUsuario(usuario)
    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario = api.updateUsuario(id, usuario)
    suspend fun eliminarUsuario(id: Int) = api.deleteUsuario(id)
}

