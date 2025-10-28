using LaudoPro.Domain.Models;

namespace LaudoPro.Domain.Interfaces.Repositories
{
    public interface IPlanRepository : IRepositoryReadOnly<Plan>
    {
        Task<Plan> GetPlanByTypeAsync(int id);
    }
}
