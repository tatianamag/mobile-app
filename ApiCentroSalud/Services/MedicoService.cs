using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using ApiCentroSalud.Models;
using Microsoft.EntityFrameworkCore;

namespace ApiCentroSalud.Services
{
    public class MedicoService : IMedicoService
    {
        private readonly CentroSaludContext _context;

        public MedicoService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<MedicoDto>> ObtenerMedicosAsync()
        {
            var medicos = await _context.Personas
                .Join(_context.Roles,
                      persona => persona.ID_persona,
                      rol => rol.ID_persona,
                      (persona, rol) => new { Persona = persona, Rol = rol })
                .Where(pr => pr.Rol.Nombre_rol == "Médico")
                .Select(pr => new MedicoDto
                {
                    Id = pr.Persona.ID_persona,
                    Nombre = pr.Persona.Nombre_completo,
                    Especialidad = _context.EspecialidadesMedico
                        .Where(e => e.ID_persona == pr.Persona.ID_persona)
                        .Select(e => e.Especialidad)
                        .FirstOrDefault()
                })
                .ToListAsync();

            return medicos;
        }

        public async Task<MedicoDto> ObtenerMedicoPorIdAsync(int id)
        {
            var medico = await _context.Personas
                .Join(_context.Roles,
                      persona => persona.ID_persona,
                      rol => rol.ID_persona,
                      (persona, rol) => new { Persona = persona, Rol = rol })
                .Where(pr => pr.Rol.Nombre_rol == "Médico" && pr.Persona.ID_persona == id)
                .Select(pr => new MedicoDto
                {
                    Id = pr.Persona.ID_persona,
                    Nombre = pr.Persona.Nombre_completo,
                    Especialidad = _context.EspecialidadesMedico
                        .Where(e => e.ID_persona == pr.Persona.ID_persona)
                        .Select(e => e.Especialidad)
                        .FirstOrDefault()
                })
                .FirstOrDefaultAsync();

            return medico;
        }
    }
}