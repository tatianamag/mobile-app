using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Pomelo.EntityFrameworkCore.MySql.Infrastructure;
using ApiCentroSalud.Data;
using Services;
using Interfaces;
using Helpers;

var builder = WebApplication.CreateBuilder(args);

// Configurar la conexión a la base de datos MySQL
builder.Services.AddDbContext<CentroSaludContext>(options =>
    options.UseMySql(builder.Configuration.GetConnectionString("MySQLConnection"), 
    ServerVersion.AutoDetect(builder.Configuration.GetConnectionString("MySQLConnection"))));

// Agregar autenticación JWT
builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new Microsoft.IdentityModel.Tokens.TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = builder.Configuration["Jwt:Issuer"],
            ValidAudience = builder.Configuration["Jwt:Audience"],
            IssuerSigningKey = new Microsoft.IdentityModel.Tokens.SymmetricSecurityKey(System.Text.Encoding.UTF8.GetBytes(builder.Configuration["Jwt:SecretKey"]))
        };
    });

// Configurar controladores
builder.Services.AddControllers();

// Agregar servicios personalizados
builder.Services.AddScoped<IAuthService, AuthService>();
builder.Services.AddScoped<ITurnoService, TurnoService>();
builder.Services.AddScoped<IPacienteService, PacienteService>();
builder.Services.AddScoped<IMedicoService, MedicoService>();
builder.Services.AddScoped<ISecretariaService, SecretariaService>();

// Agregar helpers
builder.Services.AddScoped<TokenGenerator>();
builder.Services.AddScoped<PasswordHasher>();

// Agregar Swagger para documentación
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Middleware para autenticación y autorización
app.UseAuthentication();
app.UseAuthorization();

// Swagger
app.UseSwagger();
app.UseSwaggerUI();

// Mapear los controladores
app.MapControllers();

// Ejecutar la aplicación
app.Run();
