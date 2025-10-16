using LaudoPro.Models;
using LaudoPro.Repositories;
using LaudoPro.Repositories.Interfaces;
using LaudoPro.Services.Interfaces;

namespace LaudoPro.Services
{
    public class PlanService: IPlanService
    {
        private readonly IPlanRepository _repository;
        public PlanService(IPlanRepository repository)
        {
            _repository = repository;
        }

        public async Task<IEnumerable<Plan>> GetAllPlansAsync()
        {
            return await _repository.GetAllPlansAsync();
        }
    }
}
