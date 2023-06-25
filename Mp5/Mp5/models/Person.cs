using System.ComponentModel.DataAnnotations;

namespace Mp5.models
{
    public class Person
    {
        [Key]
        public int PersonId { get; set; }
        [Required, MaxLength(30)]
        public string FirstName { get; set; }
        [Required, MaxLength(30)]
        public string LastName { get; set; }
        [EmailAddress]
        public string Email { get; set; }

    }
}
