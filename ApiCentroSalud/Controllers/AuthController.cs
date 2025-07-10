using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace ApiCentroSalud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly IAuthService _authService;

        public AuthController(IAuthService authService)
        {
            _authService = authService;
        }

        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody] LoginRequest loginRequest)
        {
            var user = await _authService.LoginPorDniAsync(loginRequest);

            if (user == null)
                return Unauthorized("Credenciales inválidas");

            return Ok(user); // Devuelve UsuarioDto con el token incluido
        }
    }
}
