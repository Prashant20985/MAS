using App.Domain.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Medicine")]
    public class Medicine
    {
        [Key]
        public int MedicineId { get; set; }

        [Required]
        public int Amount { get; set; }

        [Required, Column(TypeName = "nvarchar(20)")]
        public MedicineType MedicineType { get; set; }

        [ForeignKey(nameof(Procedure))]
        public int ProcedureId { get; set; }
        public Procedure Procedure { get; set; }
    }
}
