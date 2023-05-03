using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Certification")]
    public class Certification
    {
        [Key]
        public int CertificationId { get; set; }
        [Required, MaxLength(100)]
        public string Title { get; set; }

        public ICollection<Nurse> Nurses { get; set; } = new HashSet<Nurse>();
    }
}
