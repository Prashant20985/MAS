using System.ComponentModel.DataAnnotations;

namespace Mp5.models
{
    public class CourseMaterial
    {
        [Key]
        public int CourseMaterialId { get; set; }

        [Url]
        public string Url { get; set; }

        public Course Course { get; set; }
    }
}
