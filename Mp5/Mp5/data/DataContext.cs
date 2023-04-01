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

            modelBuilder.Entity<Teacher>().ToTable(nameof(Teacher));

            modelBuilder.Entity<Student>().ToTable(nameof(Student));

            modelBuilder.Entity<CourseMaterial>().ToTable("Course_Material")
                .HasOne(x => x.Course)
                .WithOne(y => y.CourseMaterial)
                .HasForeignKey<Course>(z => z.CourseMaterialId);

            modelBuilder.Entity<Course>().ToTable(nameof(Course));

            modelBuilder.Entity<StudentCourse>().ToTable("Student_Course");
        }
    }
}
