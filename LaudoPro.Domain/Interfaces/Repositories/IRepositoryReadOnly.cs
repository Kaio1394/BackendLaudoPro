namespace LaudoPro.Domain.Interfaces.Repositories
{
    public interface IRepositoryReadOnly<T> where T : class
    {
        Task<IEnumerable<T>> GetAllAsync();
    }
}
