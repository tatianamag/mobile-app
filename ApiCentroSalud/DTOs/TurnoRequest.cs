namespace ApiCentroSalud.DTOs
{
    public class TurnoRequest
    {
        public int PacienteId { get; set; }
        public int MedicoId { get; set; }
        public DateTime Fecha { get; set; }
    }
}
