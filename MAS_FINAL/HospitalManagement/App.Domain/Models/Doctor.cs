using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Doctor")]
    public class Doctor : MedicalStaff
    {
        [ForeignKey(nameof(Specialization))]
        public int SpecializationId { get; set; }
        public Specialization Specialization { get; set; }

        public ICollection<Appointment> Appointments { get; set; } = new HashSet<Appointment>();
    }
}
