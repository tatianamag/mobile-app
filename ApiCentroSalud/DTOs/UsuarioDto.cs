namespace ApiCentroSalud.DTOs
{
    public class UsuarioDto
{
    public int ID_persona { get; set; }      
    public string Dni { get; set; }           
    public string NombreCompleto { get; set; } 
    public string Rol { get; set; }          
    public string Token { get; set; }         
}
}
