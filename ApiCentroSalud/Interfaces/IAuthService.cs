namespace Interfaces
{
    public interface IAuthService
    {
        Task<UsuarioDto> LoginAsync(LoginRequest request);
    }
}
