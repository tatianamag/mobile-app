using Microsoft.EntityFrameworkCore;
using ApiCentroSalud.Models;

namespace ApiCentroSalud.Data
{
    public class CentroSaludContext : DbContext
    {
        public CentroSaludContext(DbContextOptions<CentroSaludContext> options)
            : base(options) { }

        public DbSet<Persona> Personas { get; set; }
        public DbSet<Roles> Roles { get; set; }
        public DbSet<Especialidad> Especialidades { get; set; }
        public DbSet<EspecialidadMedico> EspecialidadesMedico { get; set; }
        public DbSet<Motivo> Motivos { get; set; }
        public DbSet<Accion> Acciones { get; set; }
        public DbSet<Permisos> Permisos { get; set; }
        public DbSet<Turno> Turnos { get; set; }
        public DbSet<HistorialMedico> HistorialMedico { get; set; }
        public DbSet<Usuarios> Usuarios { get; set; }
        public DbSet<Secretarios> Secretarios { get; set; }
        public DbSet<DisponibilidadMedico> DisponibilidadMedico { get; set; }
    }
}
