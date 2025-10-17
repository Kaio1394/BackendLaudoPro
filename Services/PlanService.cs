using LaudoPro.DTOs;
using LaudoPro.Models;
using LaudoPro.Models.Enums;
using LaudoPro.Repositories;
using LaudoPro.Repositories.Interfaces;
using LaudoPro.Services.Interfaces;

namespace LaudoPro.Services
{
    public class PlanService : IPlanService
    {
        private readonly IPlanRepository _planRepository;

        public PlanService(IPlanRepository planRepository)
        {
            _planRepository = planRepository;
        }

        public async Task<IEnumerable<PlanDto>> GetAllAsync()
        {
            var listPlans = await _planRepository.GetAllAsync();
            var listDto = listPlans.Select(p =>
                new PlanDto { Id = p.Id, Price = p.Price, Type = p.Type.ToString() }
            );
            return listDto;
        }
    }
}
