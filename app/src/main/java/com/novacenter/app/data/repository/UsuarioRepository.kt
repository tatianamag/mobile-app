package com.novacenter.app.data.repository

import com.novacenter.app.data.model.LoginRequest
import com.novacenter.app.data.model.LoginResponse
import com.novacenter.app.data.model.Usuario
import com.novacenter.app.data.network.RetrofitInstance

class UsuarioRepository {

    private val api = RetrofitInstance.usuarioService

    suspend fun login(username: String, password: String): LoginResponse {
        val request = LoginRequest(username, password)
        return api.login(request)
    }

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
