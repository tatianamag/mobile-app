using ApiCentroSalud.DTOs;
using ApiCentroSalud.Models;
using ApiCentroSalud.Data;
using ApiCentroSalud.Interfaces;
using ApiCentroSalud.Helpers;
using Microsoft.EntityFrameworkCore;

namespace ApiCentroSalud.Services
{
    public class AuthService : IAuthService
    {
        private readonly CentroSaludContext _context;
        private readonly IConfiguration _configuration;
        private readonly TokenGenerator _tokenGenerator;

       public AuthService(CentroSaludContext context, IConfiguration configuration, TokenGenerator tokenGenerator)
{
    _context = context;
    _configuration = configuration;
     _tokenGenerator = tokenGenerator;
}
       public async Task<UsuarioDto> LoginPorDniAsync(LoginRequest request)
{
    var persona = await _context.Personas
        .FirstOrDefaultAsync(p => p.DNI == request.Dni && p.Contraseña == request.Contraseña);

    if (persona == null) return null;

    var usuario = await _context.Usuarios
        .FirstOrDefaultAsync(u => u.ID_persona == persona.ID_persona);

    if (usuario == null) return null;

    var token = _tokenGenerator.GenerateToken(persona.ID_persona, persona.DNI, "Administrador");

    return new UsuarioDto
    {
        ID_persona = persona.ID_persona,
        Dni = persona.DNI,
        NombreCompleto = persona.Nombre_completo,
        Rol = usuario.Estado,
        Token = token
    };
    }
    }
}