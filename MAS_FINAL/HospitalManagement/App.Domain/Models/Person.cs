using App.Domain.Enums;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    public abstract class Person
    {
        [Key]
        public int PersonId { get; set; }

        [Required, MaxLength(50, ErrorMessage = "Max Length is 50")]
        public string FirstName { get; set; }

        [Required, MaxLength(50, ErrorMessage = "Max Length is 50")]
        public string LastName { get; set; }

        [Required]
        public DateTime DateOfBirth { get; set; }

        [Required, Column(TypeName = "varchar(32)")]
        public Gender Gender { get; set; }

    }
}
