namespace LaudoPro.Repositories.Interfaces
{
    public interface IRepository<T> where T : class
    {
        Task<IEnumerable<T>> GetAllAsync();
        Task<T> AddAsync(T model);
        Task<T> UpdateAsync(T model);
        Task<bool> DeleteAsync(T model);
    }
}
