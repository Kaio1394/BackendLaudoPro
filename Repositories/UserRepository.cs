using LaudoPro.Data;

namespace LaudoPro.Repositories
{
    public class UserRepository
    {
        private readonly LaudoProDbContext _dbContext;

        public UserRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }
    }
}
