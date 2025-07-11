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

    // 👇 Cargar las relaciones necesarias
    _context.Entry(turno).Reference(t => t.Paciente).Load();
    _context.Entry(turno).Reference(t => t.Medico).Load();

    return new TurnoDto
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
            Cobertura = turno.Paciente.Cobertura
        },
        Medico = new MedicoDto
        {
            Id = turno.Medico.ID_persona,
            Nombre = turno.Medico.Nombre_completo,
            Especialidad = _context.EspecialidadMedico
                .Where(e => e.ID_persona == turno.ID_medico)
                .Select(e => e.Especialidad)
                .FirstOrDefault()
        }
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
    Fecha = turno.Fecha_y_hora,
    Paciente = new PacienteDto
    {
        Id = turno.Paciente.ID_persona,
        Nombre = turno.Paciente.Nombre_completo,
        Sexo = turno.Paciente.Sexo,
        Telefono = turno.Paciente.Telefono,
        DNI = turno.Paciente.DNI,
        Cobertura = turno.Paciente.Cobertura,
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

