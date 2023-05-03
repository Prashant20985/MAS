namespace App.Application.DTOs
{
    public class AppointmentUpdateDTO
    {
        public DateTime StartTime { get; set; }
        public DateTime EndTime { get; set; }
        public string RoomNumber { get; set; }
        public string Status { get; set; }
    }
}
