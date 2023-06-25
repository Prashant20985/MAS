using App.Application.Core;
using App.Application.DTOs;
using App.Domain.Enums;
using App.Persistance;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Appointment
{
    public class UpdateAppointment
    {
        public class Command : IRequest<Result<Unit>>
        {
            public int AppointmentId { get; set; }
            public AppointmentUpdateDTO Appointment { get; set; }
        }

        public class Handler : IRequestHandler<Command, Result<Unit>>
        {
            private readonly DataContext _context;

            public Handler(DataContext context)
            {
                _context = context;
            }

            public async Task<Result<Unit>> Handle(Command request, CancellationToken cancellationToken)
            {
                var appointment = await _context.Appointments
                    .FirstOrDefaultAsync(x => x.AppointmentId == request.AppointmentId);
                if (appointment == null) return null;
                var room = await _context.Rooms
                    .FirstOrDefaultAsync(x => x.RoomNumber == request.Appointment.RoomNumber);
                if (room == null) return null;

                Status status = (Status)Enum.Parse(typeof(Status), request.Appointment?.Status);

                if (request.Appointment.StartTime > request.Appointment.EndTime)
                    return Result<Unit>.Failure("End time cannot be before Start time");

                TimeSpan duration = request.Appointment.EndTime - request.Appointment.StartTime;
                double hrsDifference = duration.TotalHours;

                if (hrsDifference > 2)
                {
                    return Result<Unit>.Failure("An Appointment Cannot be longer than 2 hours");
                }

                if (request.Appointment.StartTime.Date != request.Appointment.EndTime.Date)
                {
                    return Result<Unit>.Failure("Appointemnt start time and end time must be on same date");
                }

                appointment.StartTime = request.Appointment.StartTime;
                appointment.EndTime = request.Appointment.EndTime;
                appointment.Status = status;
                appointment.RoomId = room.RoomId;

                var result = await _context.SaveChangesAsync() > 0;

                if (!result) return Result<Unit>.Failure("Failed to Update Appointment");

                return Result<Unit>.Success(Unit.Value);
            }
        }
    }
}
