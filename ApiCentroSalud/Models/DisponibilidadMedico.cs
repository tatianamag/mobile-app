namespace ApiCentroSalud.Models
{
    public class DisponibilidadMedico
    {
        public int ID_disponibilidad { get; set; }
        public int ID_persona { get; set; }
        public string DiaSemana { get; set; }
        public TimeSpan HoraInicio { get; set; }
        public TimeSpan HoraFin { get; set; }

        public Persona Medico { get; set; }  // Relación con Persona
    }
}
