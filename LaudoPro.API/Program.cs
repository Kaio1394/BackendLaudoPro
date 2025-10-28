using LaudoPro.Application.Interfaces;
using LaudoPro.Application.Mapper;
using LaudoPro.Application.Services;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Infrastructure.Data;
using LaudoPro.Infrastructure.Repositories;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

//Log.Logger = new LoggerConfiguration()
//            .ReadFrom.Configuration(builder.Configuration)
//            .Enrich.FromLogContext()
//            .CreateLogger();

//builder.Host.UseSerilog();

builder.Services.AddDbContext<LaudoProDbContext>(options =>
    options.UseSqlite("Data Source=LaudoPro.db")
);

builder.Services.AddAutoMapper(typeof(MappingProfile));
// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddScoped<IPlanRepository, PlanRepository>();
builder.Services.AddScoped<IPlanService, PlanService>();

builder.Services.AddScoped<IRoleRepository, RoleRepository>();
builder.Services.AddScoped<IRoleService, RoleService>();

builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAll", policy =>
        policy.AllowAnyOrigin().AllowAnyHeader().AllowAnyMethod());
});

var app = builder.Build();

app.UseSwagger();
app.UseSwaggerUI();

app.UseCors("AllowAll");

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();