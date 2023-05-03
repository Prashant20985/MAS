using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("ExaminationDiagnosis")]
    public class ExaminationDiagnosis
    {
        [ForeignKey(nameof(Diagnosis))]
        public int DiagnosisId { get; set; }
        public Diagnosis Diagnosis { get; set; }

        [ForeignKey(nameof(Examination))]
        public int ExaminationId { get; set; }
        public Examination Examination { get; set; }
    }
}
