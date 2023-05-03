using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Equipment")]
    public class Equipment
    {
        [Key]
        public int EquipmentId { get; set; }

        [Required, MaxLength(100)]
        public string Title { get; set; }

        [Required]
        public decimal Price { get; set; }

        public ICollection<Procedure_Equipment> Procedure_Equipment { get; set; } = new HashSet<Procedure_Equipment>();

    }
}
