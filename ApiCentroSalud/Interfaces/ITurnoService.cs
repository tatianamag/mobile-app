using ApiCentroSalud.DTOs;

namespace ApiCentroSalud.Interfaces
{
    public interface ITurnoService
    {
        Task<TurnoDto> CrearTurnoAsync(TurnoRequest turnoRequest);
        Task<IEnumerable<TurnoDto>> ObtenerTurnosAsync();
        Task<TurnoDto> ObtenerTurnoPorIdAsync(int id);
    }
}
