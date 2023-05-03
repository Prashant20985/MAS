using System.Text.Json.Serialization;

namespace App.Domain.Enums
{
    [JsonConverter(typeof(JsonStringEnumConverter))]
    public enum Gender
    {
        MALE,
        FEMALE
    }
}
