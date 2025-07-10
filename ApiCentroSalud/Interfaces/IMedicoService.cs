using ApiCentroSalud.DTOs;

namespace ApiCentroSalud.Interfaces
{
    public interface IMedicoService
    {
        Task<IEnumerable<MedicoDto>> ObtenerMedicosAsync();
        Task<MedicoDto> ObtenerMedicoPorIdAsync(int id);
    }
}
