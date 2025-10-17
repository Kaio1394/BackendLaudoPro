using LaudoPro.Models.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LaudoPro.DTOs
{
    public class PlanDto
    {
        public int Id { get; set; }
        public string Type { get; set; }
        public double Price { get; set; }
    }
}
