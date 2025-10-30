using LaudoPro.Application.DTOs.SafetyValve;
using LaudoPro.Application.Interfaces;
using LaudoPro.Application.Services;
using LaudoPro.Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.Interface
{
    public interface ISafetyValveService: IBaseService<SafetyValve, SafetyValveReadDto, SafetyValveRequestDto, SafetyValveDeleteDto> { }
}
