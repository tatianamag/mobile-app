using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace Services
{
    public class SecretariaService : ISecretariaService
    {
        private readonly CentroSaludContext _context;

        public SecretariaService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<TurnoDto>> ObtenerTurnosSecretarioAsync()
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

        public SecretarioDto ValidarSecretario(SecretarioLoginRequest loginRequest)
        {
            var secretario = _context.Secretarios
                .FirstOrDefault(s => s.Codigo == loginRequest.Codigo && s.Contraseña == loginRequest.Contraseña);

            if (secretario == null)
                return null;

            return new SecretarioDto
            {
                Codigo = secretario.Codigo,
                Estado = secretario.Estado
            };
        }
    }
}
