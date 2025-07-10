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
        public DbSet<EspecialidadMedico> EspecialidadMedico { get; set; }
        public DbSet<Motivo> Motivos { get; set; }
        public DbSet<Accion> Acciones { get; set; }
        public DbSet<Permisos> Permisos { get; set; }
        public DbSet<Turno> Turnos { get; set; }
        public DbSet<HistorialMedico> HistorialMedico { get; set; }
        public DbSet<Usuarios> Usuarios { get; set; }
        public DbSet<Secretarios> Secretarios { get; set; }
        public DbSet<DisponibilidadMedico> DisponibilidadMedico { get; set; }

        // ✅ Configuración de claves primarias y sin clave
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Claves primarias simples
            modelBuilder.Entity<Persona>().HasKey(p => p.ID_persona);
            modelBuilder.Entity<Roles>().HasKey(r => r.ID_persona);
            modelBuilder.Entity<Especialidad>().HasKey(e => e.Nombre_especialidad);
            modelBuilder.Entity<EspecialidadMedico>().HasKey(em => em.ID_persona);
            modelBuilder.Entity<Motivo>().HasKey(m => m.ID_motivo);
            modelBuilder.Entity<Accion>().HasKey(a => a.ID_accion);
            modelBuilder.Entity<Turno>().HasKey(t => t.ID_turno);
            modelBuilder.Entity<Usuarios>().HasKey(u => u.ID_persona);
            modelBuilder.Entity<Secretarios>().HasKey(s => s.Codigo);
            modelBuilder.Entity<DisponibilidadMedico>().HasKey(d => d.ID_disponibilidad);

            modelBuilder.Entity<Usuarios>()
    .HasOne(u => u.Persona)
    .WithOne()
    .HasForeignKey<Usuarios>(u => u.ID_persona);
    
            // Clave compuesta
            modelBuilder.Entity<Permisos>().HasKey(p => new { p.Nombre_rol, p.ID_accion });

            // Entidad sin clave (solo lectura)
            modelBuilder.Entity<HistorialMedico>().HasNoKey();
        }
    }
}

