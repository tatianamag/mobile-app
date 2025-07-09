using ApiCentroSalud.Data;
using ApiCentroSalud.DTOs;
using Interfaces;
using ApiCentroSalud.Models; 
using Microsoft.EntityFrameworkCore;

namespace Services
{
    public class MedicoService : IMedicoService
    {
        private readonly CentroSaludContext _context;

        public MedicoService(CentroSaludContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<MedicoDto>> ObtenerMedicosAsync()
        {
            var medicos = await _context.Medicos.ToListAsync();
            return medicos.Select(medico => new MedicoDto
            {
                Id = medico.Id,
                Nombre = medico.Nombre,
                Especialidad = medico.Especialidad
            });
        }

        public async Task<MedicoDto> ObtenerMedicoPorIdAsync(int id)
        {
            var medico = await _context.Medicos
                .FirstOrDefaultAsync(m => m.Id == id);

            if (medico == null)
                return null;

            return new MedicoDto
            {
                Id = medico.Id,
                Nombre = medico.Nombre,
                Especialidad = medico.Especialidad
            };
        }
    }
}
