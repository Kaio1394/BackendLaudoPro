using LaudoPro.Application.DTOs;
using LaudoPro.Application.Interfaces;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;

namespace LaudoPro.Application.Services
{
    public class PlanService : IPlanService
    {
        private readonly IPlanRepository _planRepository;

        public PlanService(IPlanRepository planRepository)
        {
            _planRepository = planRepository;
        }

        public async Task<IEnumerable<Plan>> GetAllAsync()
        {
            var listPlans = await _planRepository.GetAllAsync();
            return listPlans;
        }
    }
}
