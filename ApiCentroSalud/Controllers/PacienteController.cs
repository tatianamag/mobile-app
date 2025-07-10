using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace ApiCentroSalud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PacienteController : ControllerBase
    {
        private readonly IPacienteService _pacienteService;

        public PacienteController(IPacienteService pacienteService)
        {
            _pacienteService = pacienteService;
        }

        [HttpGet("listado")]
[Authorize] // Permite acceso a cualquier usuario autenticado
public async Task<IActionResult> ObtenerPacientes()
{
    var pacientes = await _pacienteService.ObtenerPacientesAsync();
    return Ok(pacientes);
}
        [HttpGet("detalle/{id}")]
        [Authorize]
        public async Task<IActionResult> ObtenerPacienteDetalle(int id)
        {
            var paciente = await _pacienteService.ObtenerPacientePorIdAsync(id);

            if (paciente == null)
                return NotFound();

            return Ok(paciente);
        }

        [HttpPost("editar/{id}")]
        [Authorize]
        public async Task<IActionResult> EditarPaciente(int id, [FromBody] PacienteUpdateRequest pacienteUpdateRequest)
        {
            var paciente = await _pacienteService.EditarPacienteAsync(id, pacienteUpdateRequest);

            if (paciente == null)
                return NotFound();

            return Ok(paciente);
        }
    }
}
