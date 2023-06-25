using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    public abstract class MedicalStaff : Person
    {
        [Required]
        [RegularExpression(@"^\d+.?\d{0,2}$", ErrorMessage = "Invalid Target Price; Maximum Two Decimal Points.")]
        [Range(0, 9999.99, ErrorMessage = "Invalid Target Rate; Max 6 digits")]
        public float RatePerHour { get; set; }

        public float MonthlySalary { get; set; }

        public abstract void calculateSalary();
    }
}
