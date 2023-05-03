using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("ProcedureType")]
    public class ProcedureType
    {
        [Key]
        public int ProcedureTypeId { get; set; }

        [Required, MaxLength(100)]
        public string Title { get; set; }

        public ICollection<Procedure> Procedures { get; set; } = new HashSet<Procedure>();
    }
}
