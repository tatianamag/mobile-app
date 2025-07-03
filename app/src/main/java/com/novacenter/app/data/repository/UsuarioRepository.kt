package com.novacenter.app.data.repository

import android.content.Context
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.network.RetrofitInstance
import com.novacenter.app.data.network.UsuarioService
import retrofit2.Response

class UsuarioRepository(context: Context) {

    private val api = RetrofitInstance.getRetrofit(context).create(UsuarioService::class.java)

    suspend fun obtenerUsuarios(): Response<List<Usuario>> = api.getUsuarios()

    suspend fun obtenerUsuario(id: Int): Response<Usuario> = api.getUsuario(id)

    suspend fun agregarUsuario(usuario: Usuario): Response<Usuario> = api.addUsuario(usuario)

    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Response<Usuario> = api.updateUsuario(id, usuario)

    suspend fun eliminarUsuario(id: Int): Response<Unit> = api.deleteUsuario(id)
}