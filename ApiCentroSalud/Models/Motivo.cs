namespace ApiCentroSalud.Models
{
    public class Motivo
    {
        public int ID_motivo { get; set; }
        public string Descripcion_motivo { get; set; }
        public string Nombre_especialidad { get; set; }

        public Especialidad Especialidad { get; set; }  // Relación con Especialidad
    }
}
