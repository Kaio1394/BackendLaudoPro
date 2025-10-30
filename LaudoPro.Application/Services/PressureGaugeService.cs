using AutoMapper;
using LaudoPro.Application.DTOs.PressureGauge;
using LaudoPro.Application.Interface;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.Services
{
    public class PressureGaugeService : BaseService<PressureGauge, PressureGaugeReadDto, PressureGaugeRequestDto, PressureGaugeDeleteDto>, IPressureGaugeService
    {
        public PressureGaugeService(IRepository<PressureGauge> repository, IMapper mapper) : base(repository, mapper) { }
    }
}
