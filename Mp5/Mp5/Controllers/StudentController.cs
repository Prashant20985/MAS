using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Mp5.DTOs.Request;
using Mp5.services;

namespace Mp5.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {
        private readonly IStudentService _service;

        public StudentController(IStudentService service)
        {
            _service = service;
        }

        [HttpGet]
        public async Task<IActionResult> GetStudents()
        {
            var result = await _service.GetStudents(); 

            if(result == null)
                return NotFound("No studnets are persent DB");

            return Ok(result);
        }

        [HttpGet("{Id}")]
        public async Task<IActionResult> GetStudent(int Id)
        {
            var result = await _service.GetStudent(Id);

            if (result == null)
                return NotFound($"Student with id: {Id} does not exits");

            return Ok(result);
        }

        [HttpGet("student/{email}")]
        public async Task<IActionResult> GetStudentByEmail(string email)
        {
            var result = await _service.GetStudentByEmailAddress(email);

            if (result == null)
                return NotFound($"Studet with email: {email} does not exists in DB");
            return Ok(result);
        }

        [HttpPost]
        public async Task<IActionResult> AddStudent(StudentDTO student)
        {
            var result = await _service.AddStudent(student);

            if (result == null)
                return BadRequest("Student wasn't added to the system");

            return Ok(result);
        }

        [HttpPut("student/{Id}")]
        public async Task<IActionResult> UpdateStudent(StudentDTO student)
        {
            var result = _service.UpdateStudent(student);

            if (result == null)
                return BadRequest("Student could not be updated");

            return Ok(result);
        }

        [HttpDelete("student/{id}")]
        public async Task<IActionResult> DeleteStudent(int id)
        {
            var result = await _service.DeleteStudent(id);

            if (result == null)
                return NotFound($"Student with id: {id} not found");

            return Ok(result );
        }
    }
}
