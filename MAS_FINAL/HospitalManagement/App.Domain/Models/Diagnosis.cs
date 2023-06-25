using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Diagnosis")]
    public class Diagnosis
    {
        [Key]
        public int DiagnosisId { get; set; }

        [Required, MaxLength(50, ErrorMessage = "Max length is 50")]
        public string Title { get; set; }

        [Required]
        public DateTime DateDiagnosed { get; set; }

        public List<Treatment> Treatments { get; set; } = new List<Treatment>();
        public List<Examination_Diagnosis> Examination_Diagnoses { get; set; } = new List<Examination_Diagnosis>();
    }
}
