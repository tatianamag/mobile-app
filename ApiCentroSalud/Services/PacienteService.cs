using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace Services
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
            var pacientes = await _context.Pacientes.ToListAsync();
            return pacientes.Select(paciente => new PacienteDto
            {
                Id = paciente.Id,
                Nombre = paciente.Nombre,
                Sexo = paciente.Sexo,
                FechaNacimiento = paciente.FechaNacimiento
            });
        }

        public async Task<PacienteDto> ObtenerPacientePorIdAsync(int id)
        {
            var paciente = await _context.Pacientes
                .FirstOrDefaultAsync(p => p.Id == id);

            if (paciente == null)
                return null;

            return new PacienteDto
            {
                Id = paciente.Id,
                Nombre = paciente.Nombre,
                Sexo = paciente.Sexo,
                FechaNacimiento = paciente.FechaNacimiento
            };
        }

        public async Task<PacienteDto> EditarPacienteAsync(int id, PacienteUpdateRequest pacienteUpdateRequest)
        {
            var paciente = await _context.Pacientes
                .FirstOrDefaultAsync(p => p.Id == id);

            if (paciente == null)
                return null;

            paciente.Nombre = pacienteUpdateRequest.Nombre;
            paciente.Sexo = pacienteUpdateRequest.Sexo;
            paciente.FechaNacimiento = pacienteUpdateRequest.FechaNacimiento;

            _context.Pacientes.Update(paciente);
            await _context.SaveChangesAsync();

            return new PacienteDto
            {
                Id = paciente.Id,
                Nombre = paciente.Nombre,
                Sexo = paciente.Sexo,
                FechaNacimiento = paciente.FechaNacimiento
            };
        }
    }
}
