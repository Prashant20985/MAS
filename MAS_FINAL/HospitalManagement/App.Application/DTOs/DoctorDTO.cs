namespace App.Application.DTOs
{
    public class DoctorDTO
    {
        public int DoctorId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public decimal RatePerHour { get; set; }
        public int Age { get; set; }
        public string Specialization { get; set; }
    }
}
