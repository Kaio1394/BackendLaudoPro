using LaudoPro.Models;

namespace LaudoPro.Repositories.Interfaces
{
    public interface IPlanRepository
    {
        Task<IEnumerable<Plan>> GetAllPlansAsync();
    }
}
