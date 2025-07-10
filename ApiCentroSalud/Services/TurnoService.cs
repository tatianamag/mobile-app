using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace ApiCentroSalud.Services
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
                ID_paciente = turnoRequest.PacienteId,
                ID_medico = turnoRequest.MedicoId,
                Fecha_y_hora = turnoRequest.Fecha,
                Fecha_solicitud = DateTime.Now,
                Estado = "Pendiente",
                Detalle_motivo = turnoRequest.DetalleMotivo,
                ID_motivo = turnoRequest.MotivoId 
            };

            _context.Turnos.Add(turno);
            await _context.SaveChangesAsync();

            return new TurnoDto
            {
                Id = turno.ID_turno,
                PacienteId = turno.ID_paciente,
                MedicoId = turno.ID_medico,
                Fecha = turno.Fecha_y_hora
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
                Id = turno.ID_turno,
                PacienteId = turno.ID_paciente,
                MedicoId = turno.ID_medico,
                Fecha = turno.Fecha_y_hora
            });
        }

        public async Task<TurnoDto> ObtenerTurnoPorIdAsync(int id)
        {
            var turno = await _context.Turnos
                .Include(t => t.Paciente)
                .Include(t => t.Medico)
                .FirstOrDefaultAsync(t => t.ID_turno == id);

            if (turno == null)
                return null;

            return new TurnoDto
            {
                Id = turno.ID_turno,
                PacienteId = turno.ID_paciente,
                MedicoId = turno.ID_medico,
                Fecha = turno.Fecha_y_hora
            };
        }
    }
}
