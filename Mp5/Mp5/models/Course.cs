using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Mp5.models
{
    public class Course
    {
        [Key]
        public int CourseId { get; set; }
        [Required]
        public string Title { get; set; }
        [Required]
        public int Credits { get; set; }

        public int TeacherId { get; set; }
        [ForeignKey(nameof(TeacherId))]
        public Teacher Teacher { get; set; }

        public int CourseMaterialId { get; set; }
        public CourseMaterial CourseMaterial { get; set; }

        public List<StudentCourse> StudentCourses { get; set; } = new List<StudentCourse>();
    }
}
