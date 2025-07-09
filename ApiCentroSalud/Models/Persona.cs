namespace ApiCentroSalud.Models
{
    public class Persona
    {
        public int ID_persona { get; set; }
        public string Nombre_completo { get; set; }
        public string Sexo { get; set; }
        public string Telefono { get; set; }
        public string DNI { get; set; }
        public string Contraseña { get; set; }
        public string Cobertura { get; set; }
        public string Tipo { get; set; }
    }
}
