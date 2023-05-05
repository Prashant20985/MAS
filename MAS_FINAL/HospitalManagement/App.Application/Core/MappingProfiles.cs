using App.Application.DTOs;
using AutoMapper;

namespace App.Application.Core
{
    public class MappingProfiles : Profile
    {
        public MappingProfiles()
        {
            CreateMap<Domain.Models.Doctor, DoctorDTO>()
                .ForMember(d => d.DoctorId, o => o.MapFrom(s => s.PersonId))
                .ForMember(d => d.Age, o => o.MapFrom(s => DateTime.Now.Year - s.DateOfBirth.Year))
                .ForMember(d => d.RatePerHour, o => o.MapFrom(s => s.ratePerHour))
                .ForMember(d => d.Specialization, o => o.MapFrom(s => s.Specialization.Title));

            CreateMap<Domain.Models.Appointment, AppointmentDTO>()
                .ForMember(d => d.RoomNumber, o => o.MapFrom(s => s.Room.RoomNumber))
                .ForMember(d => d.ProcedureTitle, o => o.MapFrom(s => s.Procedures.Select(x => x.ProcedureType.Title)));

            CreateMap<Domain.Models.Room, RoomDTO>();
        }
    }
}
