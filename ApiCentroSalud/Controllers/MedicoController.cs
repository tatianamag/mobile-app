using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace ApiCentroSalud.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MedicoController : ControllerBase
    {
        private readonly IMedicoService _medicoService;

        public MedicoController(IMedicoService medicoService)
        {
            _medicoService = medicoService;
        }

        [HttpGet("listado")]
        [Authorize(Roles = "Médico, Secretario")]
        public async Task<IActionResult> ObtenerMedicos()
        {
            var medicos = await _medicoService.ObtenerMedicosAsync();
            return Ok(medicos);
        }

        [HttpGet("detalle/{id}")]
        [Authorize]
        public async Task<IActionResult> ObtenerMedicoDetalle(int id)
        {
            var medico = await _medicoService.ObtenerMedicoPorIdAsync(id);

            if (medico == null)
                return NotFound();

            return Ok(medico);
        }
    }
}
