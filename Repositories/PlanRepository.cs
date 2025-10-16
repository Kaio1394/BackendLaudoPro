using LaudoPro.Data;
using LaudoPro.Models;
using LaudoPro.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Repositories
{
    public class PlanRepository: IPlanRepository
    {
        private readonly LaudoProDbContext _dbContext;
        public PlanRepository(LaudoProDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<IEnumerable<Plan>> GetAllPlansAsync()
        {
            return await _dbContext.Plans.ToListAsync();
        }
    }
}
