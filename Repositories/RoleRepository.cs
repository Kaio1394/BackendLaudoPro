using LaudoPro.Data;
using LaudoPro.Models;
using LaudoPro.Repositories.Base;
using LaudoPro.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Repositories
{
    public class RoleRepository : BaseReadOnlyRepository<Role>, IRoleRepository
    {
        public RoleRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
