using AutoMapper;
using AutoMapper.QueryableExtensions;
using Microsoft.EntityFrameworkCore;
using Mp5.data;
using Mp5.DTOs.Response;
using Mp5.models;

namespace Mp5.services
{
    internal interface ICourseService
    {
        Task<List<CourseDTO>> GetCourses();
        Task<string> AssignCourseToStudent(int studentId, string courseName);
        Task<string> AssignTeacherToCourse(int teacherId, string courseName);
    }
    public class CourseService : ICourseService
    {
        private readonly DataContext _context;
        private readonly IMapper _mapper; 

        public CourseService(DataContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        public async Task<string> AssignCourseToStudent(int studentId, string courseName)
        {
            var student = await _context.Students.FirstOrDefaultAsync(x => x.PersonId == studentId);
            if (student == null)
                return $"Student with personId {studentId} does not exists";

            var course = await _context.Courses.FirstOrDefaultAsync(x => x.Title.ToLower() == courseName.ToLower());
            if (course == null)
                return $"Course with name {courseName} does not exists in Database";

            var checkIfStudentAlreadyAssignedToCourse = await _context.StudentCourses
                .AnyAsync(x => x.StudentId == student.PersonId && x.CourseId == course.CourseId);

            if (checkIfStudentAlreadyAssignedToCourse)
                return "Student is already assigned to the Course";

            var studentCourse = new StudentCourse
            {
                StudentId = student.PersonId,
                CourseId = course.CourseId,
            };

            await _context.StudentCourses.AddAsync(studentCourse);
            await _context.SaveChangesAsync();
            return "Student Added to the Course";
        }

        public async Task<string> AssignTeacherToCourse(int teacherId, string courseName)
        {
            var teacher = await _context.Teachers.FirstOrDefaultAsync(x => x.PersonId == teacherId);
            if (teacher == null)
                return "Provided Teacher does not exists";

            var course = await _context.Courses.FirstOrDefaultAsync(x => x.Title.ToLower() == courseName.ToLower());
            if (course == null)
                return "Provided course does not exists";

            var checkIfTeacherIsAlreadyAssignedToCourse = await _context
                .Courses.AnyAsync(x => x.CourseId == course.CourseId && x.TeacherId == teacher.PersonId);

            if (checkIfTeacherIsAlreadyAssignedToCourse)
                return "Teacher is already assigned to course";

            course.TeacherId = teacher.PersonId;

            await _context.SaveChangesAsync();

            return $"Teacher is assigned to the course";
        }

        public async Task<List<CourseDTO>> GetCourses()
        {
            var result = await _context.Courses
                .ProjectTo<CourseDTO>(_mapper.ConfigurationProvider)
                .ToListAsync();

            return result;
        }

    }
}
