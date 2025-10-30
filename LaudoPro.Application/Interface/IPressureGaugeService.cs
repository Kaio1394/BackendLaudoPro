using LaudoPro.Application.DTOs.PressureGauge;
using LaudoPro.Application.Interfaces;
using LaudoPro.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.Interface
{
    public interface IPressureGaugeService: IBaseService<PressureGauge, PressureGaugeReadDto, PressureGaugeRequestDto, PressureGaugeDeleteDto> { }
}
