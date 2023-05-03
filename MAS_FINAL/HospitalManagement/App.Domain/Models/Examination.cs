using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Examination")]
    public class Examination
    {
        [Key]
        public int ExaminationId { get; set; }

        [ForeignKey(nameof(ExaminationType))]
        public int ExaminationTypeId { get; set; }
        public ExaminationType ExaminationType { get; set; }

        public ICollection<ExaminationDiagnosis> ExaminationDiagnoses { get; set; } = new HashSet<ExaminationDiagnosis>();
    }
}
