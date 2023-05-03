using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;


namespace App.Domain.Models
{
    [Table("Patient")]
    public class Patient : Person
    {
        [Required]
        public long InsuranceNumber { get; set; }

        [ForeignKey(nameof(Diagnosis))]
        public int DiagnosisId { get; set; }
        public Diagnosis Diagnosis { get; set; }
    }
}
