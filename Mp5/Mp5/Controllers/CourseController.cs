using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Mp5.services;

namespace Mp5.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CourseController : ControllerBase
    {
        private readonly ICourseService _courseService;

        public CourseController(ICourseService courseService)
        {
            _courseService = courseService;
        }

        [HttpGet]
        public async Task<IActionResult> GetCourses()
        {
            var result = await _courseService.GetCourses();

            if(result == null)
                return NotFound("No Courses available");

            return Ok(result);  
        }

        [HttpPost("assignCourseToStudent")]
        public async Task<IActionResult> AssignCourseToStudent(int studentId, string courseName)
        {
            var result = await _courseService.AssignCourseToStudent(studentId, courseName);

            if (!result.Equals("Student Added to the Course"))
                return BadRequest(result);

            return Ok(result);
        }

        [HttpPut("assignTeacherToCourse")]
        public async Task<IActionResult> AssignTeacherToCourse(int teacherId, string courseName)
        {
            var result = await _courseService.AssignTeacherToCourse(teacherId, courseName);

            if (!result.Equals("Teacher is assigned to the course"))
                return BadRequest(result);

            return Ok(result);
        }
    }
}
