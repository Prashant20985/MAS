using App.Domain.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Appointment")]
    public class Appointment
    {
        [Key]
        public int AppointmentId { get; set; }

        [Required]
        public DateTime StartTime { get; set; }

        [Required]
        public DateTime EndTime { get; set; }

        public int PatientId { get; set; }
        public Patient Patient { get; set; }

        [ForeignKey(nameof(Room))]
        public int RoomId { get; set; }
        public Room Room { get; set; }

        [Required, Column(TypeName = "varchar(32)")]
        public Status Status { get; set; }

        public float AppointmentCost { get; set; }

        public Procedure Procedure { get; set; }
        public Examination Examination { get; set; }
        
        public int DoctorId { get; set; }
        public Doctor Doctor { get; set; }

        public int NurseId { get; set; }
        public Nurse Nurse { get; set; }
    }
}
