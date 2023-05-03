using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Nurse")]
    public class Nurse : MedicalStaff
    {
        [ForeignKey(nameof(Cerification))]
        public int CertificationId { get; set; }
        public Certification Cerification { get; set; }

        public ICollection<Appointment> Appointments { get; set; } = new HashSet<Appointment>();
    }
}
