using LaudoPro.Domain.Models.Base;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Domain.Models
{
    [Table("safety_valve")]
    public class SafetyValve : BaseInstruments
    {
        [Required]
        [MaxLength(50)]
        [Column("actuation_gauge")]
        public string ActuationGauge { get; set; }
    }
}
