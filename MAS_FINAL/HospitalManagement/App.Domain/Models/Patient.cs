using System.ComponentModel.DataAnnotations;


namespace App.Domain.Models
{
    public class Patient : Person
    {
        [Required]
        public long InsuranceNumber { get; set; }

        public List<Appointment> Appointments { get; set; } = new List<Appointment>();

        [DisplayFormat(NullDisplayText = "N/A")]
        public List<Allergy> Allergies { get; set; }
    }
}
