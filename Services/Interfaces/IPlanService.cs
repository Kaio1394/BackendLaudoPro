using LaudoPro.Models;

namespace LaudoPro.Services.Interfaces
{
    public interface IPlanService
    {
        Task<IEnumerable<Plan>> GetAllPlansAsync();
    }
}
