using AutoMapper;
using LaudoPro.Application.DTOs.SafetyValve;
using LaudoPro.Application.Interface;
using LaudoPro.Application.Interfaces;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.Services
{
    public class SafetyValveService : BaseService<SafetyValve, SafetyValveReadDto, SafetyValveRequestDto, SafetyValveDeleteDto>, ISafetyValveService
    {
        public SafetyValveService(IRepository<SafetyValve> repository, IMapper mapper) : base(repository, mapper) { }
    }
}
