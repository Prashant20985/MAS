using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Room")]
    public class Room
    {
        [Key]
        public int RoomId { get; set; }

        [Required, MaxLength(5, ErrorMessage = "Max length is 5")]
        public string RoomNumber { get; set; }

        public List<Appointment> Appointments { get; set; } = new List<Appointment>();
    }
}
