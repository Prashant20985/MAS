namespace App.Application.DTOs
{
    public class AppointmentDTO
    {
        public int AppointmentId { get; set; }
        public DateTime StartTime { get; set; }
        public DateTime EndTime { get; set; }
        public string RoomNumber { get; set; }
        public string Status { get; set; }
        public List<string> ProcedureTitle { get; set; }
    }
}
