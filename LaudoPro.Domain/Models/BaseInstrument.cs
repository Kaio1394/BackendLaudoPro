using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LaudoPro.Domain.Models.Base
{
    public class BaseInstrument : BaseModel
    {
        [Required]
        [MaxLength(100)]
        [Column("description")]
        public string Description { get; set; }

        [Required]
        [Column("tag")]
        [MaxLength(50)]
        public string Tag { get; set; }

        [Required]
        [Column("manufacturer")]
        [MaxLength(100)]
        public string Manufacturer { get; set; }

        [Required]
        [MaxLength(100)]
        [Column("serial_number")]
        public string SerialNumber { get; set; }

        [Required]
        [MaxLength(100)]
        [Column("model")]
        public string Model { get; set; }

        [Required]
        [MaxLength(20)]
        [Column("size")]
        public string Size { get; set; }
    }
}
