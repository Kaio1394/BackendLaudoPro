using LaudoPro.DTOs;
using LaudoPro.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace LaudoProUnitTest
{
    public class InstanceClassUser
    {
        public static UserRequestDto GetUserRequestDto() 
        { 
            return new UserRequestDto
            {
                Name = "Kaio Santiago",
                Email = "kaio.santiago@example.com",
                Password = "123456",
                PlanId = 1,
                RoleId = 2
            };
        }
        public static User GetUser()
        {
            return new User
            {
                Name = "Kaio Santiago",
                Email = "kaio.santiago@example.com",
                Password = "123456",
                PlanId = 1,
                RoleId = 2
            };
        }
    }
}
