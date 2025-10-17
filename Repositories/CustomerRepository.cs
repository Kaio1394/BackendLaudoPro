using LaudoPro.Data;
using LaudoPro.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Repositories
{
    public class CustomerRepository
    {
        private readonly LaudoProDbContext _dbContext;

        public CustomerRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }
        public async Task<IEnumerable<T>> GetAll<T>() where T : class
        {
            return await _dbContext.Set<T>().ToListAsync();
        }
    }
}
