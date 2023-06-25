using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    public class Nurse : MedicalStaff
    {
        public List<Nurse_Certification> Nurse_Certifications { get; set; } = new List<Nurse_Certification>();
        public List<Appointment> Appointments { get; set; } = new List<Appointment>();

        public override void calculateSalary()
        {
            MonthlySalary = RatePerHour * 8 * 20;
        }
    }
}
