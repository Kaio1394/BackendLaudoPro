using LaudoPro.Infrastructure.Data;
using LaudoPro.Domain.Models;
using Microsoft.EntityFrameworkCore;
using LaudoPro.Domain.Interfaces.Repositories;

namespace LaudoPro.Infrastructure.Repositories
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
