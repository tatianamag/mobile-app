using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace Services
{
    public class TurnoService : ITurnoService
    {
        private readonly CentroSaludContext _context;

        public TurnoService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<TurnoDto> CrearTurnoAsync(TurnoRequest turnoRequest)
        {
            var turno = new Turno
            {
                PacienteId = turnoRequest.PacienteId,
                MedicoId = turnoRequest.MedicoId,
                Fecha = turnoRequest.Fecha
            };

            _context.Turnos.Add(turno);
            await _context.SaveChangesAsync();

            return new TurnoDto
            {
                Id = turno.Id,
                PacienteId = turno.PacienteId,
                MedicoId = turno.MedicoId,
                Fecha = turno.Fecha
            };
        }

        public async Task<IEnumerable<TurnoDto>> ObtenerTurnosAsync()
        {
            var turnos = await _context.Turnos
                .Include(t => t.Paciente)
                .Include(t => t.Medico)
                .ToListAsync();

            return turnos.Select(turno => new TurnoDto
            {
                Id = turno.Id,
                PacienteId = turno.PacienteId,
                MedicoId = turno.MedicoId,
                Fecha = turno.Fecha
            });
        }

        public async Task<TurnoDto> ObtenerTurnoPorIdAsync(int id)
        {
            var turno = await _context.Turnos
                .Include(t => t.Paciente)
                .Include(t => t.Medico)
                .FirstOrDefaultAsync(t => t.Id == id);

            if (turno == null)
                return null;

            return new TurnoDto
            {
                Id = turno.Id,
                PacienteId = turno.PacienteId,
                MedicoId = turno.MedicoId,
                Fecha = turno.Fecha
            };
        }
    }
}
