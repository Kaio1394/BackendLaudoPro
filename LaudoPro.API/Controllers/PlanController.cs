using LaudoPro.Application.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace LaudoPro.Controllers
{
    [ApiController]
    [Route("api/v1/plan")]
    public class PlanController: ControllerBase
    {
        private readonly IPlanService _service;

        public PlanController(IPlanService service)
        {
            _service = service; 
        }

        [HttpGet("list")]
        public async Task<IActionResult> GetAllPlans()
        {
            return Ok(await _service.GetAllAsync());
        }
    }
}
