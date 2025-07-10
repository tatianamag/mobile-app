namespace ApiCentroSalud.Models
{
    public class Usuarios
    {
        public int ID_persona { get; set; }
        public string Contraseña { get; set; }
        public string Estado { get; set; }

        public Persona Persona { get; set; }  // Relación con Persona
    }
}
