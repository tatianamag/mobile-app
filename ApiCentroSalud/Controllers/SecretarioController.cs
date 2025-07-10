using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace ApiCentroSalud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SecretarioController : ControllerBase
    {
        private readonly ISecretariaService _secretarioService;

        public SecretarioController(ISecretariaService secretarioService)
        {
            _secretarioService = secretarioService;
        }

        [HttpPost("login")]
        public IActionResult Login([FromBody] SecretarioLoginRequest loginRequest)
        {
            var secretario = _secretarioService.ValidarSecretario(loginRequest);

            if (secretario == null)
                return Unauthorized();

            return Ok(new { Codigo = secretario.Codigo, Contraseña = secretario.Contraseña });
        }

        [HttpGet("turnos")]
        [Authorize(Roles = "Secretario")]
        public async Task<IActionResult> ObtenerTurnosSecretario()
        {
            var turnos = await _secretarioService.ObtenerTurnosSecretarioAsync();
            return Ok(turnos);
        }
    }
}
