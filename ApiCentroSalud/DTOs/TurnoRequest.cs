namespace ApiCentroSalud.DTOs
{
    public class TurnoRequest
    {
        public int PacienteId { get; set; }
        public int MedicoId { get; set; }
        public DateTime Fecha { get; set; }
        
        public string DetalleMotivo { get; set; }   
        public int MotivoId { get; set; }
    
    }

}
