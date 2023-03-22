using AutoMapper;
using Mp5.DTOs;
using Mp5.DTOs.Request;
using Mp5.DTOs.Response;
using Mp5.models;

namespace Mp5.profiles
{
    public class MappingProfile : Profile
    {
        public MappingProfile() 
        {
            CreateMap<Student, StudentDTO>();

            CreateMap<Course, CourseDTO>();

            CreateMap<Student, StudentDetailsDTO>()
                .ForMember(s => s.Courses, o => o.MapFrom(x => x.StudentCourses
                    .Where(z => z.CourseId == z.Course.CourseId)
                    .Select(a => new CourseDTO { Title = a.Course.Title, Credits = a.Course.Credits })));

        }

    }
}
