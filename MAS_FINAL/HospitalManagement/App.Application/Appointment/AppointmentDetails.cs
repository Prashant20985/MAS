using App.Application.Core;
using App.Application.DTOs;
using App.Persistance;
using AutoMapper;
using AutoMapper.QueryableExtensions;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Appointment
{
    public class AppointmentDetails
    {
        public class Query : IRequest<Result<AppointmentDTO>>
        {
            public int AppointmentId { get; set; }
        }

        public class Handler : IRequestHandler<Query, Result<AppointmentDTO>>
        {
            private readonly DataContext _context;
            private readonly IMapper _mapper;
            public Handler(DataContext context, IMapper mapper)
            {
                _context = context;
                _mapper = mapper;
            }

            public async Task<Result<AppointmentDTO>> Handle(Query request, CancellationToken cancellationToken)
            {
                var appointment = await _context.Appointments
                    .ProjectTo<AppointmentDTO>(_mapper.ConfigurationProvider)
                    .FirstOrDefaultAsync(x => x.AppointmentId == request.AppointmentId);

                return Result<AppointmentDTO>.Success(appointment);
            }
        }
    }
}
