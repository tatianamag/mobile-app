using System.ComponentModel.DataAnnotations.Schema;

namespace ApiCentroSalud.Models
{
    [Table("Turno")]
    public class Turno
    {
        public int ID_turno { get; set; }
        public int ID_paciente { get; set; }
        public int ID_motivo { get; set; }
        public int ID_medico { get; set; }
        public DateTime Fecha_y_hora { get; set; }
        public DateTime Fecha_solicitud { get; set; }
        public DateTime? Fecha_confirmacion { get; set; }
        public string Estado { get; set; }
        public string? Detalle_motivo { get; set; }

        public Persona Paciente { get; set; }  // Relación con Persona
        public Motivo Motivo { get; set; }      // Relación con Motivo
        public Persona Medico { get; set; }    // Relación con Persona (Médico)
    }
}
