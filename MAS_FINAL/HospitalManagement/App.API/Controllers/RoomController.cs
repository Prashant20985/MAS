using App.Application.Room;
using Microsoft.AspNetCore.Mvc;

namespace App.API.Controllers
{
    public class RoomController : BaseApiController
    {
        [HttpGet]
        public async Task<IActionResult> GetRooms()
        {
            return HandleResult(await Mediator.Send(new RoomList.Query()));
        }
    }
}
