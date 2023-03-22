using AutoMapper;
using Microsoft.EntityFrameworkCore;
using Mp5.data;
using Mp5.models;
using Mp5.profiles;

namespace Mp5.Test.TestConfig
{
    public class TestConfiguration : IDisposable
    {
        public DbContextOptions<DataContext>? DbContextOptions { get; private set; }

        public IMapper Mapper { get; private set; }

        private readonly DataContext _dataContext;

        public TestConfiguration()
        {
            DbContextOptions = new DbContextOptionsBuilder<DataContext>()
                .UseInMemoryDatabase(databaseName: Guid.NewGuid().ToString())
                .Options;

            _dataContext = new DataContext(DbContextOptions);

            var mapper = new MapperConfiguration(m =>
            {
                m.AddProfile(new MappingProfile());
            });

            Mapper = mapper.CreateMapper();

            seed();
        }

        public void seed()
        {   

            var teachers = new List<Teacher>
            {
                new Teacher { PersonId = 1, FirstName = "Steve", LastName = "Rogers", Email = "cap@test.com", HireDate = new DateTime(2019, 08, 23)},
                new Teacher { PersonId = 2, FirstName = "Tony", LastName = "Stark", Email = "ironman@test.com", HireDate = new DateTime(2009, 11, 13)},
                new Teacher { PersonId = 3, FirstName = "Nick", LastName = "Fury", Email = "fury@test.com", HireDate = new DateTime(2019, 05, 03)}
            };

            _dataContext.Teachers.AddRange(teachers);

            var students = new List<Student>
            {
                new Student { PersonId = 4, FirstName = "Barry", LastName = "Allen", Email = "flash@test.com", EnrollmentDate = new DateTime(2020, 02, 14)},
                new Student { PersonId = 5, FirstName = "Bruce", LastName = "Wayne", Email = "batman@test.com", EnrollmentDate = new DateTime(2021, 04, 02)},
                new Student { PersonId = 6, FirstName = "Clark", LastName = "Kent", Email = "superman@test.com", EnrollmentDate = new DateTime(2023, 01, 09) },
                new Student { PersonId = 7, FirstName = "Hal", LastName = "Jordarn", Email = "lantern@test.com", EnrollmentDate = new DateTime(202, 07, 09) }
            };

            _dataContext.Students.AddRange(students);

            var courseMaterial = new List<CourseMaterial>
            {
                    new CourseMaterial { CourseMaterialId = 1, Url = "https://anyuri1.com"},
                    new CourseMaterial { CourseMaterialId = 2, Url = "https://anyuri2.com"},
                    new CourseMaterial { CourseMaterialId = 3, Url = "https://anyuri3.com"},
                    new CourseMaterial { CourseMaterialId = 4, Url = "https://anyuri4.com"},
            };

            _dataContext.CourseMaterials.AddRange(courseMaterial);

            var courses = new List<Course>
            {
                    new Course { CourseId = 1, Title = "MAS", Credits = 7, TeacherId = 1, CourseMaterialId = 1},
                    new Course { CourseId = 2, Title = "SBD", Credits = 5, TeacherId = 2, CourseMaterialId = 2},
                    new Course { CourseId = 3, Title = "SOP", Credits = 7, TeacherId =3, CourseMaterialId = 3},
                    new Course { CourseId = 4, Title = "ASD", Credits = 7, CourseMaterialId = 4}
            };

            _dataContext.Courses.AddRange(courses);

            var studentCourses = new List<StudentCourse>
            {
                new StudentCourse { StudentCourseId = 1, StudentId = 4, CourseId = 1},
                new StudentCourse { StudentCourseId = 2, StudentId = 4, CourseId = 2},
                new StudentCourse { StudentCourseId = 3, StudentId = 5, CourseId = 2},
                new StudentCourse { StudentCourseId = 4, StudentId = 6, CourseId = 3}
            };

            _dataContext.StudentCourses.AddRange(studentCourses);
            _dataContext.SaveChanges();
        }

        public void Dispose()
        {
            DbContextOptions = null;
            _dataContext.Dispose();
        }
    }
}
