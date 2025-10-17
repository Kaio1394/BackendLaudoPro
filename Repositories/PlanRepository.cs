using LaudoPro.Data;
using LaudoPro.Models;
using LaudoPro.Repositories.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Repositories
{
    public class PlanRepository: BaseReadOnlyRepository<Plan>, IPlanRepository
    {
        public PlanRepository(LaudoProDbContext dbContext) : base(dbContext) { }

        public async Task<Plan?> GetPlanByTypeAsync(int id)
        {
            return await _dbContext.Plans
                                   .FirstOrDefaultAsync(p => p.Id == id);
        }
    }
}
