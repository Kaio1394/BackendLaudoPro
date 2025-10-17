namespace LaudoPro.DTOs
{
    public class UserDto
    {
        public string Uuid { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public int PlanId { get; set; }
        public int RoleId { get; set; }
    }
}
