using LaudoPro.Models.Base;

namespace LaudoPro.Models
{
    public class User: BaseModel
    {
        public string name;
        public string email;
        public string password;
    }
}
