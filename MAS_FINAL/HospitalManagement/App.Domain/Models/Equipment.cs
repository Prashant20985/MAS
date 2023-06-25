using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Equipment")]
    public class Equipment
    {
        [Key]
        public int EquipmentId { get; set; }

        [Required, MaxLength(50, ErrorMessage = "Max length is 50")]
        public string Title { get; set; }

        [RegularExpression(@"^\d+.?\d{0,2}$", ErrorMessage = "Invalid Target Price; Maximum Two Decimal Points.")]
        [Range(0, 9999.99, ErrorMessage = "Invalid Target Rate; Max 6 digits")]
        public float PricePerProcedure { get; set; }

        public List<Procedure_Equipment> Procedure_Equipment { get; set; } = new List<Procedure_Equipment>();
    }
}
