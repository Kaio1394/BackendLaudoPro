using AutoMapper;
using LaudoPro.DTOs;
using LaudoPro.Repositories.Interfaces;
using LaudoPro.Services.Interfaces;
using Microsoft.EntityFrameworkCore;
using System;

namespace LaudoPro.Services
{
    public class BaseService<TEntity, TReadDto, TUpdateCreateDto, TDeleteDto> 
        : IBaseService<TEntity, TReadDto, TUpdateCreateDto, TDeleteDto>
        where TEntity : class
        where TReadDto : class
        where TUpdateCreateDto : class
        where TDeleteDto : class, IHasUuid
    {
        protected readonly IRepository<TEntity> _repository;
        protected readonly IMapper _mapper;

        public BaseService(IRepository<TEntity> repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        public async Task<TReadDto> AddAsync(TUpdateCreateDto dto)
        {
            try
            {
                var entity = _mapper.Map<TEntity>(dto);
                var created = await _repository.AddAsync(entity);
                return _mapper.Map<TReadDto>(created);
            }
            catch (AutoMapperMappingException ex)
            {
                throw new InvalidOperationException("Erro ao mapear DTO para entidade.", ex);
            }
            catch (DbUpdateException ex)
            {
                throw new InvalidOperationException("Erro ao salvar no banco de dados.", ex);
            }
        }

        public async Task<bool> DeleteAsync(TDeleteDto dto)
        {
            var entity = await _repository.GetByUuidAsync(dto.Uuid);
            if (entity == null) return false;

            return await _repository.DeleteAsync(entity);
        }

        public async Task<IEnumerable<TReadDto>> GetAllAsync()
        {
            var dtos = await _repository.GetAllAsync();
            return _mapper.Map<IEnumerable<TReadDto>>(dtos);
        }

        public Task<TReadDto> GetByUuidAsync(string uuid)
        {
            throw new NotImplementedException();
        }

        public Task<TReadDto> UpdateAsync(TUpdateCreateDto dto)
        {
            throw new NotImplementedException();
        }
    }
}
