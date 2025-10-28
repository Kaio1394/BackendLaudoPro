using AutoMapper;
using LaudoPro.Application.DTOs;
using LaudoPro.Domain.Interfaces.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.Base
{
    public class BaseAppService<TEntity, TReadDto, TUpdateCreateDto, TDeleteDto>
        : IBaseAppService<TEntity, TReadDto, TUpdateCreateDto, TDeleteDto>
        where TEntity : class
        where TReadDto : class
        where TUpdateCreateDto : class
        where TDeleteDto : class, IHasUuid
    {
        protected readonly IRepository<TEntity> _repository;
        protected readonly IMapper _mapper;

        public BaseAppService(IRepository<TEntity> repository, IMapper mapper)
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

        public async Task<TReadDto> GetByUuidAsync(string uuid)
        {
            var list = await _repository.GetByUuidAsync(uuid);
            return _mapper.Map<TReadDto>(list);
        }

        public Task<TReadDto> UpdateAsync(TUpdateCreateDto dto)
        {
            throw new NotImplementedException();
        }
    }
}
