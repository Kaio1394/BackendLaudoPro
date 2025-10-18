using LaudoPro.Models;

namespace LaudoPro.Services.Interfaces
{
    public interface IBaseService<TEntity, TReadDto, TUpdateCreateDto, TDeleteDto> 
        where TEntity : class
        where TReadDto : class
        where TUpdateCreateDto : class
        where TDeleteDto : class
    {
        Task<IEnumerable<TReadDto>> GetAllAsync();
        Task<TReadDto> AddAsync(TUpdateCreateDto entity);
        Task<TReadDto> UpdateAsync(TUpdateCreateDto entity);
        Task<bool> DeleteAsync(TDeleteDto entity);
        Task<TReadDto> GetByUuidAsync(string uuid);
    }
}
