using ApiCentroSalud.DTOs;         
using ApiCentroSalud.Models;       
using ApiCentroSalud.Data;          
using Interfaces;                  
using Microsoft.EntityFrameworkCore; 


namespace Services
{
    public class AuthService : IAuthService
    {
        private readonly CentroSaludContext _context;

        public AuthService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<UsuarioDto> LoginAsync(LoginRequest request)
        {
            var user = await _context.Usuarios
                .FirstOrDefaultAsync(u => u.Codigo == request.Codigo && u.Contraseña == request.Contraseña);

            if (user == null)
                return null;

            return new UsuarioDto
            {
                Id = user.Id,
                Codigo = user.Codigo,
                Nombre = user.Nombre,
                Rol = user.Rol
            };
        }
    }
}
