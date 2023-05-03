using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Specialization")]
    public class Specialization
    {
        [Key]
        public int SecializationId { get; set; }
        [Required, MaxLength(100)]
        public string Title { get; set; }
        public ICollection<Doctor> Doctors { get; set; } = new HashSet<Doctor>();
    }
}
