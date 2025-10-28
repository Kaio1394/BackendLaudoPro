using LaudoPro.Infrastructure.Data;
using LaudoPro.Domain.Models;
using LaudoPro.Domain.Interfaces.Repositories;

namespace LaudoPro.Infrastructure.Repositories
{
    public class CustomerRepository: BaseRepository<Customer>, ICustomerRepository
    {
        public CustomerRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
