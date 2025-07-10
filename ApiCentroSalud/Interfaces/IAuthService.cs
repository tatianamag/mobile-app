using ApiCentroSalud.DTOs;

namespace ApiCentroSalud.Interfaces
{
    public interface IAuthService
    {
        Task<UsuarioDto> LoginAsync(LoginRequest request);
    }
}
