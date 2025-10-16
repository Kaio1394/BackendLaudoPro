using LaudoPro.Data;
using LaudoPro.Models;
using LaudoPro.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Repositories
{
    public class RoleRepository : IRoleRepository
    {
        private readonly LaudoProDbContext _dbContext;

        public RoleRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<IEnumerable<Role>> GetAllRolesAsync()
        {
            return await _dbContext.Roles.ToListAsync();
        }
    }
}
