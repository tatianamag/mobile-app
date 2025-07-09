using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace ApiCentroSalud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TurnoController : ControllerBase
    {
        private readonly ITurnoService _turnoService;

        public TurnoController(ITurnoService turnoService)
        {
            _turnoService = turnoService;
        }

        [HttpPost("agregar")]
        [Authorize]
        public async Task<IActionResult> CrearTurno([FromBody] TurnoRequest turnoRequest)
        {
            var turno = await _turnoService.CrearTurnoAsync(turnoRequest);

            if (turno == null)
                return BadRequest("No se pudo crear el turno");

            return Ok(turno);
        }

        [HttpGet("listado")]
        [Authorize]
        public async Task<IActionResult> ObtenerTurnos()
        {
            var turnos = await _turnoService.ObtenerTurnosAsync();
            return Ok(turnos);
        }

        [HttpGet("detalle/{id}")]
        [Authorize]
        public async Task<IActionResult> ObtenerTurnoDetalle(int id)
        {
            var turno = await _turnoService.ObtenerTurnoPorIdAsync(id);

            if (turno == null)
                return NotFound();

            return Ok(turno);
        }
    }
}
