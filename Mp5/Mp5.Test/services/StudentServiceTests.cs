using AutoMapper;
using Mp5.data;
using Mp5.DTOs.Request;
using Mp5.services;
using Mp5.Test.TestConfig;

namespace Mp5.Test.services
{
    public class StudentServiceTests : IDisposable
    {

        private readonly TestConfiguration _configuration;
        private readonly DataContext _dataContext;
        private readonly IMapper _mapper;

        public StudentServiceTests()
        {
            _configuration = new TestConfiguration();
            _mapper = _configuration.Mapper;
            _dataContext = new DataContext(_configuration.DbContextOptions);
        }

        public StudentService CreateService()
        {
            return new StudentService(_dataContext, _mapper);
        }

        public void Dispose()
        {
            _dataContext.Dispose();
            _configuration.Dispose();
        }

        [Fact]
        public async Task GetStudent_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            int Id = 5;
            // Act
            var result = await service.GetStudent(Id);
            // Assert
            Assert.NotNull(result);
            Assert.Equal("Bruce", result.FirstName);
            Assert.Equal("Wayne", result.LastName);
            Assert.Equal("batman@test.com", result.Email);
            Assert.Single(result.Courses);
            _dataContext.Database.EnsureDeleted();
        }

        [Fact]
        public async Task GetStudentByEmailAddress_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            string email = "batman@test.com";

            // Act
            var result = await service.GetStudentByEmailAddress(email);

            // Assert
            Assert.NotNull(result);
            Assert.Equal("Bruce", result.FirstName);
            Assert.Equal("Wayne", result.LastName);
            Assert.Single(result.Courses);
            _dataContext.Database.EnsureDeleted();
        }

        [Fact]
        public async Task GetStudents_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            // Act
            var result = await service.GetStudents();
            // Assert
            Assert.NotNull(result);
            Assert.Equal(4, result.Count());
            _dataContext.Database.EnsureDeleted();
        }


        [Fact]
        public async Task UpdateStudent_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            StudentDTO student = new StudentDTO
            {
                FirstName = "Test",
                LastName = "Test",
                Email = "flash@test.com",
                EnrollmentDate = new DateTime(2020, 02, 28)
            };

            // Act
            var result = await service.UpdateStudent(student);

            // Assert
            Assert.NotNull(result);
            Assert.Equal($"Student with {student.Email} Updated", result);
            _dataContext.Database.EnsureDeleted();
        }

        [Fact]
        public async Task DeleteStudent_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();

            int Id = 6;

            // Act
            var result = await service.DeleteStudent(Id);

            // Assert
            Assert.NotNull(result);
            Assert.Equal($"Student Clark Kent deleted", result);
            _dataContext.Database.EnsureDeleted();
        }

        [Fact]
        public async Task AddStudent_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            StudentDTO student = new StudentDTO
            {
                FirstName = "Test",
                LastName = "Test",
                Email = "testy@test.com",
                EnrollmentDate = DateTime.Now,
            };

            // Act
            var result = await service.AddStudent(student);

            // Assert
            Assert.NotNull(result);
            Assert.Equal("Studnet Added", result);
            _dataContext.Database.EnsureDeleted();
        }
    }
}
