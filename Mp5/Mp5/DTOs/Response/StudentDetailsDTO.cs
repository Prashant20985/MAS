using Mp5.models;

namespace Mp5.DTOs.Response
{
    public class StudentDetailsDTO
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public DateTime EnrollmentDate { get; set; }
        public List<CourseDTO> Courses { get; set; }
    }
}
