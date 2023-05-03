using App.Application.Appointment;
using App.Application.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace App.API.Controllers
{
    public class AppointmentController : BaseApiController
    {
        [HttpGet("doctor/{doctorId}")]
        public async Task<IActionResult> GetAppointments(int doctorId)
        {
            return HandleResult(await Mediator.Send(new AppointmentList.Query { DoctorId = doctorId }));
        }

        [HttpGet("{appointmentId}")]
        public async Task<IActionResult> GetAppointment(int appointmentId)
        {
            return HandleResult(await Mediator.Send(new AppointmentDetails.Query { AppointmentId = appointmentId }));
        }

        [HttpPut("{appointmentId}")]
        public async Task<IActionResult> UpdateAppointment(int appointmentId, AppointmentUpdateDTO appointment)
        {
            return HandleResult(await Mediator.Send(new UpdateAppointment.Command { AppointmentId = appointmentId, Appointment = appointment }));
        }
    }
}
