namespace ApiCentroSalud.Models
{
    public class EspecialidadMedico
    {
        public int ID_persona { get; set; }
        public string Especialidad { get; set; }

        public Persona Persona { get; set; }  // Relación con Persona
    }
}
