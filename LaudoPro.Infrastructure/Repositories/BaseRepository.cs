using LaudoPro.Infrastructure.Data;
using Microsoft.EntityFrameworkCore;
using LaudoPro.Domain.Interfaces.Repositories;

namespace LaudoPro.Infrastructure.Repositories
{
    public class BaseRepository<T> : IRepository<T> where T : class
    {
        protected readonly LaudoProDbContext _dbContext;

        public BaseRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<IEnumerable<T>> GetAllAsync()
        {
            return await _dbContext.Set<T>().ToListAsync();
        }

        public async Task<T> AddAsync(T entity)
        {
            var entry = await _dbContext.Set<T>().AddAsync(entity);
            await _dbContext.SaveChangesAsync();
            return entry.Entity;
        }

        public async Task<T> UpdateAsync(T entity)
        {
            _dbContext.Set<T>().Update(entity);
            await _dbContext.SaveChangesAsync();
            return entity;
        }

        public async Task<bool> DeleteAsync(T entity)
        {
            _dbContext.Set<T>().Remove(entity);
            return await _dbContext.SaveChangesAsync() > 0;
        }

        public async Task<T?> GetByUuidAsync(string uuid)
        {
            var entity = await _dbContext.Set<T>()
                .AsQueryable()
                .FirstOrDefaultAsync(e =>
                    EF.Property<string>(e, "Uuid") == uuid);

            return entity;
        }
    }
}
