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

        public async Task<IEnumerable<Role>> GetAllRolesAsync()
        {
            return await _repository.GetAllRolesAsync();
        }
    }
}
