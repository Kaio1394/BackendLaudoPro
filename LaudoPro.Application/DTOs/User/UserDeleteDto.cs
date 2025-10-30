using LaudoPro.Application.Interface;

namespace LaudoPro.Application.DTOs.User
{
    public class UserDeleteDto : IHasUuid
    {
        public string Uuid { get; set; }
    }
}
