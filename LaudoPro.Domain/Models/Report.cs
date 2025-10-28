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
    public class Report : BaseModel
    {
        [Required]
        [ForeignKey("WorkOrder")]
        public WorkOrder WorkOrder { get; set; }

        [Required]
        [ForeignKey("Customer")]
        public Customer Customer { get; set; }
    }
}
