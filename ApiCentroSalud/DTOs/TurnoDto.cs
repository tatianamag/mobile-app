namespace ApiCentroSalud.DTOs
{
    public class TurnoDto
    {
        public int Id { get; set; }
        public int PacienteId { get; set; }
        public int MedicoId { get; set; }
        public DateTime Fecha { get; set; }
        public PacienteDto Paciente { get; set; }
        public MedicoDto Medico { get; set; }
    }
}
