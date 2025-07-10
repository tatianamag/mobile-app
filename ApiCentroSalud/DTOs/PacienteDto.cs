namespace ApiCentroSalud.DTOs
{
    public class PacienteDto
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Sexo { get; set; }
        public DateTime FechaNacimiento { get; set; }
        
        public string Telefono { get; set; }
        public string DNI { get; set; }
        public string Cobertura { get; set; }    
    }

}
