using App.Application.Core;
using App.Application.DTOs;
using App.Persistance;
using AutoMapper;
using AutoMapper.QueryableExtensions;
using MediatR;
using Microsoft.EntityFrameworkCore;

namespace App.Application.Room
{
    public class RoomList
    {
        public class Query : IRequest<Result<List<RoomDTO>>> { }

        public class Handler : IRequestHandler<Query, Result<List<RoomDTO>>>
        {
            private readonly DataContext _context;
            private readonly IMapper _mapper;

            public Handler(DataContext context, IMapper mapper)
            {
                _context = context;
                _mapper = mapper;
            }

            public async Task<Result<List<RoomDTO>>> Handle(Query request, CancellationToken cancellationToken)
            {
                var rooms = await _context.Rooms
                    .ProjectTo<RoomDTO>(_mapper.ConfigurationProvider)
                    .ToListAsync(cancellationToken);

                return Result<List<RoomDTO>>.Success(rooms);
            }
        }
    }
}
