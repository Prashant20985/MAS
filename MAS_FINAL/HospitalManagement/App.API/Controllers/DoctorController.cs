using App.Application.Doctor;
using Microsoft.AspNetCore.Mvc;

namespace App.API.Controllers
{
    public class DoctorController : BaseApiController
    {
        [HttpGet]
        public async Task<IActionResult> GetDoctors()
        {
            return HandleResult(await Mediator.Send(new DoctorsList.Query()));
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetDoctor(int id)
        {
            return HandleResult(await Mediator.Send(new DoctorDetails.Query { Id = id }));
        }
    }
}
