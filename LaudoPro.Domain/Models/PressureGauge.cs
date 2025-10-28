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
    [Table("pressure_gauge")]
    public class PressureGauge : BaseInstruments
    {
        [MaxLength(50)]
        [Column("resolution")]
        [Required]
        public string Resolution { get; set; }

        [MaxLength(200)]
        [Column("tolerance")]
        [Required]
        public string Tolerance { get; set; }
    }
}
