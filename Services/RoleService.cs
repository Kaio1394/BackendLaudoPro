using LaudoPro.DTOs;
using LaudoPro.Models;
using LaudoPro.Repositories.Interfaces;
using LaudoPro.Services.Interfaces;

namespace LaudoPro.Services
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
