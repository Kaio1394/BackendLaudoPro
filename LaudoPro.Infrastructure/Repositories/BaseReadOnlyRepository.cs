using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Infrastructure.Data;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Infrastructure.Repositories
{
    public class BaseReadOnlyRepository<T> : IRepositoryReadOnly<T> where T : class
    {
        protected readonly LaudoProDbContext _dbContext;

        public BaseReadOnlyRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<IEnumerable<T>> GetAllAsync()
        {
            return await _dbContext.Set<T>().ToListAsync();
        }
    }
}
