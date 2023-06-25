using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Procedure_Equipment")]
    public class Procedure_Equipment
    {
        [ForeignKey(nameof(Procedure))]
        public int ProcedureId { get; set; }
        public Procedure Procedure { get; set; }

        [ForeignKey(nameof(Equipment))]
        public int EquipmentId { get; set; }
        public Equipment Equipment { get; set; }
    }
}
