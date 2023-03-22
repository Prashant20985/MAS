using AutoMapper;
using AutoMapper.QueryableExtensions;
using Microsoft.EntityFrameworkCore;
using Mp5.data;
using Mp5.DTOs.Request;
using Mp5.DTOs.Response;
using Mp5.models;

namespace Mp5.services
{
    public interface IStudentService
    {
        Task<string> AddStudent(StudentDTO student);
        Task<List<StudentDTO>> GetStudents();
        Task<StudentDetailsDTO> GetStudent(int Id);
        Task<StudentDetailsDTO> GetStudentByEmailAddress(string email);
        Task<string> UpdateStudent(StudentDTO student);
        Task<string> DeleteStudent(int Id);
    }
    public class StudentService : IStudentService
    {
        private readonly DataContext _context;
        private readonly IMapper _mapper;

        public StudentService(DataContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        public async Task<string> AddStudent(StudentDTO student)
        {
            var checkEmail = await _context.People.AnyAsync(x => x.Email == student.Email);
            if (checkEmail)
                return $"email: {student.Email} is already taken";

            var newStudent = new Student
            {
                FirstName = student.FirstName,
                LastName = student.LastName,
                Email = student.Email,
                EnrollmentDate = student.EnrollmentDate
            };

            await _context.Students.AddAsync(newStudent);
            await _context.SaveChangesAsync();

            return "Studnet Added";
        }

        public async Task<string> DeleteStudent(int Id)
        {
            var student = await _context.People.FirstOrDefaultAsync(x => x.PersonId == Id);
            if (student == null)
                return null;

            _context.People.Remove(student);
            await _context.SaveChangesAsync();

            return $"Student {student.FirstName} {student.LastName} deleted";
        }

        public async Task<StudentDetailsDTO> GetStudent(int Id)
        {
            var result = await _context.Students
                .Where(x => x.PersonId == Id)
                .ProjectTo<StudentDetailsDTO>(_mapper.ConfigurationProvider)
                .FirstOrDefaultAsync();

            return result;
        }

        public async Task<StudentDetailsDTO> GetStudentByEmailAddress(string email)
        {
            var result = await _context.Students
                .Where(x => x.Email == email)
                .ProjectTo<StudentDetailsDTO>(_mapper.ConfigurationProvider)
                .FirstOrDefaultAsync();

            return result;
        }

        public async Task<List<StudentDTO>> GetStudents()
        {
            var result = await _context.Students
                .ProjectTo<StudentDTO>(_mapper.ConfigurationProvider)
                .ToListAsync();

            return result;
        }

        public async Task<string> UpdateStudent(StudentDTO student)
        {
            var studentToUpdate = await _context.Students
                .FirstOrDefaultAsync(x => x.Email == student.Email);

            studentToUpdate.FirstName = student.FirstName;
            studentToUpdate.LastName = student.LastName;
            studentToUpdate.EnrollmentDate = student.EnrollmentDate;

            var result = await _context.SaveChangesAsync();

            if (result == 1)
                return $"Student with {student.Email} Updated";

            return null;
        }
    }
}
