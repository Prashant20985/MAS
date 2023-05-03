using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Room")]
    public class Room
    {
        [Key]
        public int RoomId { get; set; }

        [Required, MaxLength(5)]
        public string RoomNumber { get; set; }

        public ICollection<Appointment> Appointments { get; set; } = new HashSet<Appointment>();
    }
}
