using App.Application.Core;
using App.Application.DTOs;
using App.Persistance;
using AutoMapper;
using AutoMapper.QueryableExtensions;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Appointment
{
    public class AppointmentList
    {
        public class Query : IRequest<Result<List<AppointmentDTO>>>
        {
            public int DoctorId { get; set; }
        }

        public class Handler : IRequestHandler<Query, Result<List<AppointmentDTO>>>
        {
            private readonly DataContext _context;
            private readonly IMapper _mapper;
            public Handler(DataContext context, IMapper mapper)
            {
                _context = context;
                _mapper = mapper;
            }

            public async Task<Result<List<AppointmentDTO>>> Handle(Query request, CancellationToken cancellationToken)
            {
                var appointments = await _context.Appointments
                    .Where(x => x.DoctorId == request.DoctorId)
                    .ProjectTo<AppointmentDTO>(_mapper.ConfigurationProvider)
                    .OrderBy(x => x.StartTime)
                    .ToListAsync(cancellationToken);

                return Result<List<AppointmentDTO>>.Success(appointments);
            }
        }
    }
}
