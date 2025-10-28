using LaudoPro.Infrastructure.Data;
using LaudoPro.Domain.Models;
using LaudoPro.Domain.Interfaces.Repositories;

namespace LaudoPro.Infrastructure.Repositories
{
    public class RoleRepository : BaseReadOnlyRepository<Role>, IRoleRepository
    {
        public RoleRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
