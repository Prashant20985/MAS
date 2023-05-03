using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace App.Domain.Models
{
    [Table("Procedure")]
    public class Procedure
    {
        [Key]
        public int ProcedureId { get; set; }

        [ForeignKey(nameof(Treatment))]
        public int TreatmentId { get; set; }
        public Treatment Treatment { get; set; }

        [ForeignKey(nameof(ProcedureType))]
        public int ProcedureTypeId { get; set; }
        public ProcedureType ProcedureType { get; set; }

        [ForeignKey(nameof(Appointment))]
        public int AppointmentId { get; set; }
        public Appointment Appointment { get; set; }

        public ICollection<Medicine> Medicines { get; set; } = new HashSet<Medicine>();
        public ICollection<Procedure_Equipment> Procedure_Equipment { get; set; } = new HashSet<Procedure_Equipment>();

    }
}
