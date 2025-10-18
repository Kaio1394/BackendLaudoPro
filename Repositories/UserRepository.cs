using LaudoPro.Data;
using LaudoPro.Models;
using LaudoPro.Repositories.Base;
using LaudoPro.Repositories.Interfaces;

namespace LaudoPro.Repositories
{
    public class UserRepository : BaseRepository<User>, IUserRepository
    {
        public UserRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
