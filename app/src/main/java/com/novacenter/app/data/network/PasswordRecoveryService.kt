import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

data class RecuperarRequest(val email: String)
data class RestablecerRequest(val token: String, val nuevaContrasena: String)

interface PasswordRecoveryService {
    @POST("auth/solicitar-recuperacion")
    suspend fun solicitarRecuperacion(@Body req: RecuperarRequest): Response<String>

    @POST("auth/restablecer")
    suspend fun restablecer(@Body req: RestablecerRequest): Response<String>
}