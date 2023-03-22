using System.ComponentModel.DataAnnotations;

namespace Mp5.models
{
    public class Teacher : Person
    {
        [Required]
        public DateTime HireDate { get; set; }

        public List<Course> Courses { get; set; } = new List<Course>();
    }
}
