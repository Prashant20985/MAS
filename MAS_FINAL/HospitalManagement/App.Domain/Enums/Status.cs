using System.Text.Json.Serialization;

namespace App.Domain.Enums
{
    [JsonConverter(typeof(JsonStringEnumConverter))]
    public enum Status
    {
        BOOKED,
        CANCELLED,
        AVAILABLE
    }
}
