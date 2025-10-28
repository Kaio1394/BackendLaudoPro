namespace LaudoPro.Application.Interfaces
{
    public interface IBaseServiceReadOnly<T> where T : class
    {
        Task<IEnumerable<T>> GetAllAsync();
    }
}
