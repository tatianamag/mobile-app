using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using ApiCentroSalud.Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace ApiCentroSalud.Services
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
                Id = turno.ID_turno,               
                PacienteId = turno.ID_paciente,    
                MedicoId = turno.ID_medico,        
                Fecha = turno.Fecha_y_hora    
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
                Contraseña = secretario.Contraseña
            };
        }
    }
}
