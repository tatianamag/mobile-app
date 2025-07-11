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
    Fecha = turno.Fecha_y_hora,
    Paciente = new PacienteDto
    {
        Id = turno.Paciente.ID_persona,
        Nombre = turno.Paciente.Nombre_completo,
        Sexo = turno.Paciente.Sexo,
        Telefono = turno.Paciente.Telefono,
        DNI = turno.Paciente.DNI,
        Cobertura = turno.Paciente.Cobertura,
        // ✏️ Si querés ocultar FechaNacimiento:
        FechaNacimiento = DateTime.MinValue
    },
    Medico = new MedicoDto
    {
        Id = turno.Medico.ID_persona,
        Nombre = turno.Medico.Nombre_completo,
        Especialidad = _context.EspecialidadMedico
            .Where(e => e.ID_persona == turno.Medico.ID_persona)
            .Select(e => e.Especialidad)
            .FirstOrDefault()
    }
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

