using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("ExaminationType")]
    public class ExaminationType
    {
        [Key]
        public int ExaminationTypeId { get; set; }

        [Required, MaxLength(20)]
        public string Title { get; set; }

        public ICollection<Examination> Examinations { get; set; } = new HashSet<Examination>();
    }
}
