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
                .ForMember(d => d.RatePerHour, o => o.MapFrom(s => s.RatePerHour))
                .ForMember(d => d.Salary, o => o.MapFrom(s => s.MonthlySalary))
                .ForMember(d => d.Specialization, o => o.MapFrom(s => string.Join(", ", s.Doctor_Specializations.Select(x => x.Specialization.Title))));


            CreateMap<Domain.Models.Appointment, AppointmentDTO>()
                .ForMember(d => d.RoomNumber, o => o.MapFrom(s => s.Room.RoomNumber))
                .ForMember(d => d.ProcedureTitle, o => o.MapFrom(s => s.Procedure.ProcedureType.Title))
                .ForMember(d => d.PatientName, o => o.MapFrom(s => $"{s.Patient.FirstName} {s.Patient.LastName}"))
                .ForMember(d => d.NurseName, o => o.MapFrom(s => $"{s.Nurse.FirstName} {s.Nurse.LastName}"))
                .ForMember(d => d.ExaminationType, o => o.MapFrom(s => s.Examination.ExaminationType.Title))
                .ForMember(d => d.TotalCost, o => o.MapFrom(s => s.AppointmentCost + 
                        s.Procedure.Procedure_Equipment.Sum(z => z.Equipment.PricePerProcedure)));

            CreateMap<Domain.Models.Room, RoomDTO>();
        }
    }
}
