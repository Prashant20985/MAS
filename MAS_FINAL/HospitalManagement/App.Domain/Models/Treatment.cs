using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Treatment")]
    public class Treatment
    {
        [Key]
        public int TreatmentId { get; set; }

        [Required,MaxLength(50, ErrorMessage = "Max Length is 50")]
        public string Title { get; set; }

        [ForeignKey(nameof(Diagnosis))]
        public int DiagnosisId { get; set; }
        public Diagnosis Diagnosis { get; set; }

        public List<Procedure> procedures { get; set; } = new List<Procedure>();
    }
}
