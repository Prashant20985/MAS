using Microsoft.EntityFrameworkCore;
using Mp5.models;

namespace Mp5.data
{
    public class DataContext : DbContext
    {
        public DataContext()
        {

        }

        public DataContext(DbContextOptions options) : base(options)
        {

        }

        public DbSet<Person> People { get; set; }
        public DbSet<Teacher> Teachers { get; set; }
        public DbSet<Student> Students { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<StudentCourse> StudentCourses { get; set; }
        public DbSet<CourseMaterial> CourseMaterials { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Person>().ToTable(nameof(Person));

            modelBuilder.Entity<Teacher>().ToTable(nameof(Teacher))
                .HasData(
                    new Teacher { PersonId = 1, FirstName = "Steve", LastName = "Rogers", Email = "cap@test.com", HireDate = new DateTime(2019, 08, 23)},
                    new Teacher { PersonId = 2, FirstName = "Tony", LastName = "Stark", Email = "ironman@test.com", HireDate = new DateTime(2009, 11, 13)},
                    new Teacher { PersonId = 3, FirstName = "Nick", LastName = "Fury", Email = "fury@test.com", HireDate = new DateTime(2019, 05, 03)}
                );

            modelBuilder.Entity<Student>().ToTable(nameof(Student))
                .HasData(
                    new Student { PersonId = 4, FirstName = "Barry", LastName = "Allen", Email = "flash@test.com", EnrollmentDate = new DateTime(2020, 02, 14)},
                    new Student { PersonId = 5, FirstName = "Bruce", LastName = "Wayne", Email = "batman@test.com", EnrollmentDate = new DateTime(2021, 04, 02)},
                    new Student { PersonId = 6, FirstName = "Clark", LastName = "Kent", Email = "superman@test.com", EnrollmentDate = new DateTime(2023, 01, 09) }
                );

            modelBuilder.Entity<CourseMaterial>().ToTable("Course_Material")
                .HasOne(x => x.Course)
                .WithOne(y => y.CourseMaterial)
                .HasForeignKey<Course>(z => z.CourseMaterialId);

            modelBuilder.Entity<CourseMaterial>()
                .HasData(
                    new CourseMaterial { CourseMaterialId = 1, Url = "https://anyuri1.com"},
                    new CourseMaterial { CourseMaterialId = 2, Url = "https://anyuri2.com"},
                    new CourseMaterial { CourseMaterialId = 3, Url = "https://anyuri3.com"}
                );

            modelBuilder.Entity<Course>().ToTable(nameof(Course))
                .HasData(
                    new Course { CourseId = 1, Title = "MAS", Credits = 7, TeacherId = 1, CourseMaterialId = 1},
                    new Course { CourseId = 2, Title = "SBD", Credits = 5, TeacherId = 2, CourseMaterialId = 2},
                    new Course { CourseId = 3, Title = "SOP", Credits = 7, TeacherId =3, CourseMaterialId = 3}
                );

            modelBuilder.Entity<StudentCourse>().ToTable("Student_Course");

            modelBuilder.Entity<StudentCourse>()
                .HasData(
                    new StudentCourse { StudentCourseId = 1, StudentId = 4, CourseId = 1},
                    new StudentCourse { StudentCourseId = 2, StudentId = 4, CourseId = 2},
                    new StudentCourse { StudentCourseId = 3, StudentId = 5, CourseId = 2},
                    new StudentCourse { StudentCourseId = 4, StudentId = 6, CourseId = 3}
                );
        }

    }
}
