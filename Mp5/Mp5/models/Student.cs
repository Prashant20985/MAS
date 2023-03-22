using System.ComponentModel.DataAnnotations;

namespace Mp5.models
{
    public class Student : Person
    {
        [Required]
        public DateTime EnrollmentDate { get; set; }

        public List<StudentCourse> StudentCourses { get; set; } = new List<StudentCourse>();
    }
}
