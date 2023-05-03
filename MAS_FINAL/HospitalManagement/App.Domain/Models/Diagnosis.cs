using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Diagnosis")]
    public class Diagnosis
    {
        [Key]
        public int DiagnosisId { get; set; }

        [Required, MaxLength(100)]
        public string Title { get; set; }

        public ICollection<Patient> Patients { get; set; } = new HashSet<Patient>();
        public ICollection<Treatment> Treatments { get; set; } = new HashSet<Treatment>();
        public ICollection<ExaminationDiagnosis> ExaminationDiagnoses { get; set; } = new HashSet<ExaminationDiagnosis>();
    }
}
