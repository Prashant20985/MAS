using App.Domain.Models;

namespace App.Application.DTOs
{
    public class DoctorDTO
    {
        public int DoctorId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public float RatePerHour { get; set; }
        public int Age { get; set; }
        public float Salary { get; set; }
        public string Specialization { get; set; }
    }
}
