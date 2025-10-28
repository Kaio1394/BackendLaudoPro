using LaudoPro.Domain.Models.Base;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.IO;
using System.Text.RegularExpressions;
using System.Xml.Linq;

namespace LaudoPro.Domain.Models
{
    [Table("customers")]
    public class Customer: BaseModel
    {
        [Required]
        public string FantasyName { get; set; }
        [Required]
        public string Email { get; set; }
        [Required]
        public string Cnpj{ get; set; }
        [Required]
        public string CnpjFormated { get; set; }
        [Required]
        public string Address { get; set; }
        [Required]
        public User User { get; set; }
    }
}
