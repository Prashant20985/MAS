using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Procedure_Equipment")]
    public class Procedure_Equipment
    {
        [ForeignKey(nameof(Equipment))]
        public int EquipmentId { get; set; }
        public Equipment Equipment { get; set; }

        [ForeignKey(nameof(Procedure))]
        public int ProceureId { get; set; }
        public Procedure Procedure { get; set; }
    }
}
