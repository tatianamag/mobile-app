namespace ApiCentroSalud.Models
{
    public class Roles
    {
        public int ID_persona { get; set; }
        public string Nombre_rol { get; set; }

        public Persona Persona { get; set; }  // Relación con Persona
    }
}
