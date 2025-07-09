namespace ApiCentroSalud.DTOs
{
    public class PacienteUpdateRequest
    {
        public string Nombre { get; set; }
        public string Sexo { get; set; }
        public DateTime FechaNacimiento { get; set; }
    }
}
