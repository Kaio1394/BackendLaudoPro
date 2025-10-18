using LaudoPro.DTOs;
using LaudoPro.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace LaudoPro.Controllers
{
    [ApiController]
    [Route("api/v1/user")]
    public class UserController: ControllerBase
    {
        private readonly IUserService _userService;
        public UserController(IUserService userService)
        {
            _userService = userService;
        }

        [HttpPost]
        public async Task<IActionResult> GetUsers([FromBody] UserRequestDto dto)
        {
            try
            {
                var result = await _userService.AddAsync(dto);
                return Ok(result);
            }
            catch (Exception e)
            {
                return BadRequest(new {
                    Error = e.Message,
                });
            }       
        }
    }
}
