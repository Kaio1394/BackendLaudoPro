using LaudoPro.Application.DTOs;
using LaudoPro.Domain.Models;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Application.Interfaces;

namespace LaudoPro.Application.Services
{
    public class RoleService : IRoleService
    {
        private readonly IRoleRepository _repository;

        public RoleService(IRoleRepository repository)
        {
            _repository = repository;
        }

        public async Task<IEnumerable<RoleDto>> GetAllAsync()
        {
            var listRoles = await _repository.GetAllAsync();
            var listDto = listRoles.Select(r => new RoleDto
            {
                Id = r.Id,
                Type = r.Type.ToString(),
            });
            return listDto;
        }
    }
}
