using AutoMapper;
using LaudoPro.DTOs;
using LaudoPro.Models;

namespace LaudoPro.DTOs.Mapper
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
