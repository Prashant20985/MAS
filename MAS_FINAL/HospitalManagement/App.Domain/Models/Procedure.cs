﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace App.Domain.Models
{
    [Table("Procedure")]
    public class Procedure
    {
        [Key]
        public int ProcedureId { get; set; }

        [ForeignKey(nameof(ProcedureType))]
        public int ProcedureTypeId { get; set; }
        public ProcedureType ProcedureType { get; set; }

        [ForeignKey(nameof(Treatment))]
        public int TreatmentId { get; set; }
        public Treatment Treatment { get; set; }

        [ForeignKey(nameof(Appointment))]
        public int AppointmentId { get; set; }
        public Appointment Appointment { get; set; }

        public List<Medicine> Medicines { get; set; } = new List<Medicine>();

        public List<Procedure_Equipment> Procedure_Equipment { get; set; } = new List<Procedure_Equipment>();
    }
}
