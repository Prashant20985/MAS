using App.Application.Core;
using App.Application.DTOs;
using App.Persistance;
using AutoMapper;
using AutoMapper.QueryableExtensions;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Doctor
{
    public class DoctorsList
    {
        public class Query : IRequest<Result<List<DoctorDTO>>> { }

        public class Handler : IRequestHandler<Query, Result<List<DoctorDTO>>>
        {
            private readonly DataContext _context;
            private readonly IMapper _mapper;

            public Handler(DataContext context, IMapper mapper)
            {
                _context = context;
                _mapper = mapper;
            }

            public async Task<Result<List<DoctorDTO>>> Handle(Query request, CancellationToken cancellationToken)
            {
                var docotrs = await _context.Doctors
                    .ProjectTo<DoctorDTO>(_mapper.ConfigurationProvider)
                    .ToListAsync(cancellationToken);

                return Result<List<DoctorDTO>>.Success(docotrs);
            }
        }
    }
}
