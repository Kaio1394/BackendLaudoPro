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
    [Table("work_orders")]
    public class WorkOrder : BaseModel
    {
        private const int UUID_PARTIAL = 8;
        private const string DATE_FORMAT = "yyyyMMdd";
        
        [Required]
        [MaxLength(20)]
        public string Number { get; set; }

        [Column("calibration_date")]
        public DateTime CalibrationDate { get; set; }

        public WorkOrder()
        {
            if (string.IsNullOrEmpty(Number))
            {
                Number = GenerateWorkOrderNumber();
            }
        }

        private string GenerateWorkOrderNumber()
        {
            var datePart = DateTime.UtcNow.ToString(DATE_FORMAT);
            var uuidPart = Uuid.Substring(0, UUID_PARTIAL).ToUpper();
            return $"{datePart}-{uuidPart}";
        }
    }
}
