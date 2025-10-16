using LaudoPro.Models.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LaudoPro.Models
{
    [Table("plans")]
    public class Plan
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [Column("type")]
        public PlanType Type { get; set; }

        [Required]
        public double Price { get; set; }
    }
}
