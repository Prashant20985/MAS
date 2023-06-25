using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Specialization")]
    public class Specialization
    {
        [Key]
        public int SpecializationId { get; set; }

        public string Title { get; set; }

        public List<Doctor_Specialization> Doctor_Specializations { get; set; } = new List<Doctor_Specialization>();
    }
}
