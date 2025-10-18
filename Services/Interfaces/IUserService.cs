using LaudoPro.DTOs;
using LaudoPro.Models;

namespace LaudoPro.Services.Interfaces
{
    public interface IUserService : IBaseService<User, UserReadDto, UserRequestDto, UserDeleteDto>
    {
    }
}
