using LaudoPro.Models;
using LaudoPro.Models.Enums;

namespace LaudoPro.Repositories.Interfaces
{
    public interface IPlanRepository : IRepositoryReadOnly<Plan>
    {
        Task<Plan> GetPlanByTypeAsync(int id);
    }
}
