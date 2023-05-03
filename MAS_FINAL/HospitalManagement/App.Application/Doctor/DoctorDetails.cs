using App.Application.Core;
using App.Application.DTOs;
using App.Persistance;
using AutoMapper;
using AutoMapper.QueryableExtensions;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Doctor
{
    public class DoctorDetails
    {
        public class Query : IRequest<Result<DoctorDTO>>
        {
            public int Id { get; set; }
        }

        public class Handler : IRequestHandler<Query, Result<DoctorDTO>>
        {
            private readonly DataContext _context;
            private readonly IMapper _mapper;
            public Handler(DataContext context, IMapper mapper)
            {
                _context = context;
                _mapper = mapper;
            }

            public async Task<Result<DoctorDTO>> Handle(Query request, CancellationToken cancellationToken)
            {
                var doctor = await _context.Doctors
                    .ProjectTo<DoctorDTO>(_mapper.ConfigurationProvider)
                    .FirstOrDefaultAsync(x => x.DoctorId == request.Id);

                return Result<DoctorDTO>.Success(doctor);
            }
        }
    }
}
