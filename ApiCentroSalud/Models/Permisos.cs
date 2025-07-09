namespace ApiCentroSalud.Models
{
    public class Permisos
    {
        public string Nombre_rol { get; set; }
        public int ID_accion { get; set; }

        public Accion Accion { get; set; }  // Relación con Accion
    }
}
