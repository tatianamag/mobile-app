namespace ApiCentroSalud.Models
{
    public class HistorialMedico
    {
        public int ID_paciente { get; set; }
        public string Nombre_paciente { get; set; }
        public DateTime Fecha_creacion { get; set; }
        public string Diagnostico { get; set; }
        public string Tratamiento { get; set; }

        public Persona Paciente { get; set; }  // Relación con Persona
    }
}
