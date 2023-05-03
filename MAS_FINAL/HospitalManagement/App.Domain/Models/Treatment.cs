using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Treatment")]
    public class Treatment
    {
        [Key]
        public int TreatmentId { get; set; }

        [Required, MaxLength(30)]
        public string Title { get; set; }

        [ForeignKey(nameof(Diagnosis))]
        public int DiagnosisId { get; set; }
        public Diagnosis Diagnosis { get; set; }

        public ICollection<Procedure> Procedures { get; set; } = new HashSet<Procedure>();

    }
}
