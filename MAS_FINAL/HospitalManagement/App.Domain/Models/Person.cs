using App.Domain.Enums;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Person")]
    public class Person
    {
        [Key]
        public int PersonId { get; set; }

        [Required, MaxLength(30, ErrorMessage = "Max Length is 30")]
        public string FirstName { get; set; }

        [Required, MaxLength(30, ErrorMessage = "Max Length is 30")]
        public string LastName { get; set; }

        public DateTime DateOfBirth { get; set; }

        [Required, Column(TypeName = "nvarchar(6)")]
        public Gender Gender { get; set; }
    }
}
