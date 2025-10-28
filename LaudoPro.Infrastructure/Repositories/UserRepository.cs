using LaudoPro.Infrastructure.Data;
using LaudoPro.Domain.Models;
using LaudoPro.Domain.Interfaces.Repositories;

namespace LaudoPro.Infrastructure.Repositories
{
    public class UserRepository : BaseRepository<User>, IUserRepository
    {
        public UserRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
