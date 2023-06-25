using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    public class Doctor : MedicalStaff
    {
        [DisplayFormat(NullDisplayText = "N/A")]
        public float BonusPerAppointment { get; set; }

        public List<Doctor_Specialization> Doctor_Specializations { get; set; } = new List<Doctor_Specialization>();
        public List<Appointment> Appointments { get; set; } = new List<Appointment>();

        public override void calculateSalary()
        {
            int numberOfAppointmnets = Appointments.Count(x => x.DoctorId == this.PersonId);
            MonthlySalary = RatePerHour * 8 * 20;
            MonthlySalary += BonusPerAppointment * numberOfAppointmnets;
        }
    }
}
