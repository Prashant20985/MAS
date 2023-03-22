using System.ComponentModel.DataAnnotations;

namespace Mp5.DTOs.Request
{
    public class StudentDTO
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public DateTime EnrollmentDate { get; set; }
    }
}
