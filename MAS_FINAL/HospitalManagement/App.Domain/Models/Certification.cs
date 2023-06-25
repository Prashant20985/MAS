using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Certification")]
    public class Certification
    {
        [Key]
        public int CertificationId { get; set; }

        [Required]
        public string Title { get; set; }

        public List<Nurse_Certification> Nurse_Certifications { get; set; } = new List<Nurse_Certification>();
    }
}
