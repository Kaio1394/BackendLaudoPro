using AutoMapper;
using LaudoPro.Application.DTOs;
using LaudoPro.Domain.Models;

namespace LaudoPro.Application.Mapper
{
    public class MappingProfile: Profile
    {
        public MappingProfile()
        {
            CreateMap<User, UserDeleteDto>().ReverseMap();
            CreateMap<User, UserRequestDto>().ReverseMap();
            CreateMap<User, UserReadDto>().ReverseMap();
            CreateMap<Role, RoleDto>().ReverseMap();
        }
    }
}
