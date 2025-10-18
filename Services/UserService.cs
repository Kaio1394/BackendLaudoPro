using AutoMapper;
using LaudoPro.DTOs;
using LaudoPro.Models;
using LaudoPro.Repositories.Interfaces;
using LaudoPro.Services.Interfaces;

namespace LaudoPro.Services
{
    public class UserService : BaseService<User, UserReadDto, UserRequestDto, UserDeleteDto>, IUserService
    {
        public UserService(IUserRepository repository, IMapper mapper) : base(repository, mapper) { }
    }
}
