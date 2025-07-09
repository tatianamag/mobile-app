namespace Interfaces
{
    public interface IPacienteService
    {
        Task<IEnumerable<PacienteDto>> ObtenerPacientesAsync();
        Task<PacienteDto> ObtenerPacientePorIdAsync(int id);
        Task<PacienteDto> EditarPacienteAsync(int id, PacienteUpdateRequest pacienteUpdateRequest);
    }
}
