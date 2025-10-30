using AutoMapper;
using LaudoPro.Application.DTOs;
using LaudoPro.Application.DTOs.PressureGauge;
using LaudoPro.Application.DTOs.SafetyValve;
using LaudoPro.Application.DTOs.User;
using LaudoPro.Domain.Models;

namespace LaudoPro.Application.Mapper
{
    public class MappingProfile: Profile
    {
        public MappingProfile()
        {
            CreateMap<Role, RoleDto>().ReverseMap();

            CreateMap<User, UserDeleteDto>().ReverseMap();
            CreateMap<User, UserRequestDto>().ReverseMap();
            CreateMap<User, UserReadDto>().ReverseMap();

            CreateMap<PressureGauge, PressureGaugeDeleteDto>().ReverseMap();
            CreateMap<PressureGauge, PressureGaugeReadDto>().ReverseMap();
            CreateMap<PressureGauge, PressureGaugeRequestDto>().ReverseMap();

            CreateMap<SafetyValve, SafetyValveDeleteDto>().ReverseMap();
            CreateMap<SafetyValve, SafetyValveReadDto>().ReverseMap();
            CreateMap<SafetyValve, SafetyValveRequestDto>().ReverseMap();
        }
    }
}
