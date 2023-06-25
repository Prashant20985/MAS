using App.Domain.Models;

namespace App.Application.DTOs
{
    public class AppointmentDTO
    {
        public int AppointmentId { get; set; }
        public DateTime StartTime { get; set; }
        public DateTime EndTime { get; set; }
        public string RoomNumber { get; set; }
        public string Status { get; set; }
        public string PatientName { get; set; }
        public string NurseName { get; set; }
        public string ProcedureTitle { get; set; }
        public string ExaminationType { get; set; }
        public float TotalCost { get; set; }
    }
}
