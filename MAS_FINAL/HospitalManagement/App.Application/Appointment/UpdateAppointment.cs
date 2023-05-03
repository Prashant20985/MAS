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
