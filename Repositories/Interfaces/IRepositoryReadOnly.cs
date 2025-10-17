namespace LaudoPro.Repositories.Interfaces
{
    public interface IRepositoryReadOnly<T> where T : class
    {
        Task<IEnumerable<T>> GetAllAsync();
    }
}
