import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface QRService {
    @GET("qr/generar/{idTurno}")
    suspend fun generarQR(@Path("idTurno") idTurno: Int): Response<ResponseBody>
}