using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using ApiCentroSalud.Models;
using Microsoft.EntityFrameworkCore;

namespace ApiCentroSalud.Services
{
    public class PacienteService : IPacienteService
    {
        private readonly CentroSaludContext _context;

        public PacienteService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<PacienteDto>> ObtenerPacientesAsync()
        {
            var pacientes = await _context.Personas
                .Where(p => p.Tipo == "Paciente")
                .Select(p => new PacienteDto
                {
                    Id = p.ID_persona,
                    Nombre = p.Nombre_completo,
                    Sexo = p.Sexo,
                    Telefono = p.Telefono,
                    DNI = p.DNI,
                    Cobertura = p.Cobertura
                    // ✅ Puedes extender el DTO si agregás más campos
                })
                .ToListAsync();

            return pacientes;
        }

        public async Task<PacienteDto> ObtenerPacientePorIdAsync(int id)
        {
            var paciente = await _context.Personas
                .Where(p => p.Tipo == "Paciente" && p.ID_persona == id)
                .FirstOrDefaultAsync();

            if (paciente == null)
                return null;

            return new PacienteDto
            {
                Id = paciente.ID_persona,
                Nombre = paciente.Nombre_completo,
                Sexo = paciente.Sexo,
                Telefono = paciente.Telefono,
                DNI = paciente.DNI,
                Cobertura = paciente.Cobertura
            };
        }

        public async Task<PacienteDto> EditarPacienteAsync(int id, PacienteUpdateRequest pacienteUpdateRequest)
        {
            var paciente = await _context.Personas
                .Where(p => p.Tipo == "Paciente" && p.ID_persona == id)
                .FirstOrDefaultAsync();

            if (paciente == null)
                return null;

            paciente.Nombre_completo = pacienteUpdateRequest.Nombre;
            paciente.Sexo = pacienteUpdateRequest.Sexo;
            paciente.Telefono = pacienteUpdateRequest.Telefono;
            paciente.DNI = pacienteUpdateRequest.DNI;
            paciente.Cobertura = pacienteUpdateRequest.Cobertura;

            _context.Personas.Update(paciente);
            await _context.SaveChangesAsync();

            return new PacienteDto
            {
                Id = paciente.ID_persona,
                Nombre = paciente.Nombre_completo,
                Sexo = paciente.Sexo,
                Telefono = paciente.Telefono,
                DNI = paciente.DNI,
                Cobertura = paciente.Cobertura
            };
        }
    }
}