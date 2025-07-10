using ApiCentroSalud.DTOs;

namespace ApiCentroSalud.Interfaces
{
    public interface ISecretariaService
    {
        Task<IEnumerable<TurnoDto>> ObtenerTurnosSecretarioAsync();
        SecretarioDto ValidarSecretario(SecretarioLoginRequest loginRequest);
    }
}
