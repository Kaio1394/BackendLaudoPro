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

        [HttpGet("by-uuid")]
        public async Task<IActionResult> GetUserByUuid([FromHeader] string uuid)
        {
            try
            {
                if(string.IsNullOrEmpty(uuid))
                    return BadRequest("Header UUID is required.");
                var user = await _userService.GetByUuidAsync(uuid);
                return Ok(user);
            }
            catch(Exception e) 
            {
                return BadRequest(new
                {
                    Error = e.Message
                });
            }
        }
    }
}
