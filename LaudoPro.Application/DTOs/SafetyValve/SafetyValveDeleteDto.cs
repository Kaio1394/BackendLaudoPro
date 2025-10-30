using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Application.DTOs.SafetyValve
{
    public class SafetyValveDeleteDto : IHasUuid
    {
        public string Uuid { get; set; }
    }
}
