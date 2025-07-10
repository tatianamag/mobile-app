using System;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Text;
using System.Security.Claims;

namespace ApiCentroSalud.Helpers
{
    public class TokenGenerator
    {
        private readonly string _secretKey;

        public TokenGenerator(string secretKey)
        {
            _secretKey = secretKey;
        }

        public string GenerateToken(int idPersona, string dni, string rol)
{
    var claims = new[]
    {
        new Claim("ID_persona", idPersona.ToString()),
        new Claim("Dni", dni),
        new Claim(ClaimTypes.Role, rol ?? "Usuario")
    };

    var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_secretKey));
    var credentials = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

    var token = new JwtSecurityToken(
        issuer: "CentroSaludAPI",
        audience: "CentroSaludUsers",
        claims: claims,
        expires: DateTime.Now.AddHours(1),
        signingCredentials: credentials);

    return new JwtSecurityTokenHandler().WriteToken(token);
}
    }
}
