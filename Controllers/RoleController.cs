﻿using LaudoPro.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace LaudoPro.Controllers
{
    [ApiController]
    [Route("api/v1/role")]
    public class RoleController: ControllerBase
    {
        private readonly IRoleService _service;
        public RoleController(IRoleService service)
        {
            _service = service;
        }

        [HttpGet("list")]
        public async Task<IActionResult> GetAllRoles()
        {
            var listRoles = await _service.GetAllRolesAsync();
            return Ok(listRoles);
        }
    }
}
