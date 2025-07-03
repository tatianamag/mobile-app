import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface TokenQRValidatorService {
    @GET("qr/validar/{token}")
    suspend fun validar(@Path("token") token: String): Response<String>
}