using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("ExaminationType")]
    public class ExaminationType
    {
        [Key]
        public int ExaminationTypeId { get; set; }

        [Required, MaxLength(50, ErrorMessage = "Max length is 50")]
        public string Title { get; set; }

        public List<Examination> Examinations { get; set; } = new List<Examination>();
    }
}
