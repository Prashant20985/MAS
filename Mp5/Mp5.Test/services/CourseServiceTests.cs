using AutoMapper;
using Mp5.data;
using Mp5.services;
using Mp5.Test.TestConfig;

namespace Mp5.Test.services
{
    public class CourseServiceTests : IDisposable
    {
        private readonly TestConfiguration _config;
        private readonly DataContext _dataContext;
        private readonly IMapper _mapper;

        public CourseServiceTests()
        {
            _config = new TestConfiguration();
            _mapper = _config.Mapper;
            _dataContext = new DataContext(_config.DbContextOptions);
        }

        public CourseService CreateService()
        {
            return new CourseService(_dataContext, _mapper);
        }

        public void Dispose()
        {
            _dataContext.Dispose();
            _config.Dispose();
        }

        [Fact]
        public async Task AssignTeacherToCourse_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            int teacherId = 3;
            string courseName = "ASD";

            // Act
            var result = await service.AssignTeacherToCourse(teacherId, courseName);

            // Assert
            Assert.NotNull(result);
            Assert.Equal("Teacher is assigned to the course", result);
        }


        [Fact]
        public async Task GetCourses_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();

            // Act
            var result = await service.GetCourses();

            // Assert
            Assert.Equal(4, result.Count());
        }

        [Fact]
        public async Task AssignCourseToStudent_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            var service = CreateService();
            int studentId = 7;
            string courseName = "SOP";

            // Act
            var result = await service.AssignCourseToStudent(studentId, courseName);

            // Assert
            Assert.Equal("Student Added to the Course", result);
        }

    }
}
