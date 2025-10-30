using LaudoPro.Application.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.DTOs.PressureGauge
{
    public class PressureGaugeDeleteDto: IHasUuid
    {
        public string Uuid { get; set; }
    }
}
