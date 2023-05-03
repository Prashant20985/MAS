using App.Domain.Enums;
using App.Domain.Models;
using Microsoft.EntityFrameworkCore;

namespace App.Persistance
{
    public class DataContext : DbContext
    {
        public DataContext()
        {

        }

        public DataContext(DbContextOptions options) : base(options)
        {

        }

        public DbSet<Person> People { get; set; }
        public DbSet<Patient> Patients { get; set; }
        public DbSet<MedicalStaff> MedicalStaff { get; set; }
        public DbSet<Doctor> Doctors { get; set; }
        public DbSet<Nurse> Nurses { get; set; }
        public DbSet<Specialization> Specializations { get; set; }
        public DbSet<Certification> Cerifications { get; set; }
        public DbSet<Diagnosis> Diagnoses { get; set; }
        public DbSet<Treatment> Treatments { get; set; }
        public DbSet<Medicine> Medicines { get; set; }
        public DbSet<Procedure> Procedures { get; set; }
        public DbSet<ProcedureType> ProcedureTypes { get; set; }
        public DbSet<Equipment> Equipment { get; set; }
        public DbSet<Room> Rooms { get; set; }
        public DbSet<Appointment> Appointments { get; set; }
        public DbSet<Procedure_Equipment> Procedure_Equipment { get; set; }
        public DbSet<Examination> Examinations { get; set; }
        public DbSet<ExaminationDiagnosis> ExaminationDiagnoses { get; set; }
        public DbSet<ExaminationType> ExaminationTypes { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Procedure_Equipment>()
                .HasKey(x => new { x.EquipmentId, x.ProceureId });

            modelBuilder.Entity<ExaminationDiagnosis>()
                .HasKey(x => new { x.DiagnosisId, x.ExaminationId });


            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Nurse)
                .WithMany(y => y.Appointments)
                .HasForeignKey(z => z.NurseId)
                .OnDelete(DeleteBehavior.NoAction); // Deleting Doctor object wont delete Appointments associated to it 

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Doctor)
                .WithMany(y => y.Appointments)
                .HasForeignKey(z => z.DoctorId)
                .OnDelete(DeleteBehavior.NoAction); // Deleting Nurse object wont delete Appointments associated to it 

            // Seed Data
            modelBuilder.Entity<Specialization>()
                .HasData(
                    new Specialization { SecializationId = 1, Title = "Dentistry" },
                    new Specialization { SecializationId = 2, Title = "Cardiology" }
                );

            modelBuilder.Entity<Certification>()
                .HasData(
                    new Certification { CertificationId = 1, Title = "any title" },
                    new Certification { CertificationId = 2, Title = "any title" }
                );

            modelBuilder.Entity<Diagnosis>()
                .HasData(
                    new Diagnosis { DiagnosisId = 1, Title = "Kemo" },
                    new Diagnosis { DiagnosisId = 2, Title = "ECG" }
                );

            modelBuilder.Entity<Doctor>()
                .HasData(
                    new Doctor { PersonId = 1, FirstName = "Bruce", LastName = "Wayne", DateOfBirth = new DateTime(2000, 01, 01), Gender = Gender.MALE, ratePerHour = 100.00m, SpecializationId = 1 },
                    new Doctor { PersonId = 2, FirstName = "Clark", LastName = "Kent", DateOfBirth = new DateTime(1999, 05, 01), Gender = Gender.MALE, ratePerHour = 150.99m, SpecializationId = 2 }
                );

            modelBuilder.Entity<Nurse>()
                .HasData(
                    new Nurse { PersonId = 3, FirstName = "Dianna", LastName = "Price", DateOfBirth = new DateTime(1998, 05, 07), Gender = Gender.FEMALE, ratePerHour = 90.99m, CertificationId = 1 },
                    new Nurse { PersonId = 4, FirstName = "Barry", LastName = "Allen", DateOfBirth = new DateTime(1998, 05, 08), Gender = Gender.MALE, ratePerHour = 90.99m, CertificationId = 2 }
                );

            modelBuilder.Entity<Patient>()
                .HasData(
                    new Patient { PersonId = 5, FirstName = "Victor", LastName = "Stone", DateOfBirth = new DateTime(2002, 08, 22), Gender = Gender.MALE, InsuranceNumber = 12365478, DiagnosisId = 1 },
                    new Patient { PersonId = 6, FirstName = "Arthur", LastName = "Curry", DateOfBirth = new DateTime(2002, 08, 26), Gender = Gender.FEMALE, InsuranceNumber = 12365008, DiagnosisId = 2 }
                );

            modelBuilder.Entity<Treatment>()
                .HasData(
                    new Treatment { TreatmentId = 1, Title = "Main", DiagnosisId = 1 },
                    new Treatment { TreatmentId = 2, Title = "Secondry", DiagnosisId = 2 }
                );

            modelBuilder.Entity<ProcedureType>()
                .HasData(
                    new ProcedureType { ProcedureTypeId = 1, Title = "Dont Know" },
                    new ProcedureType { ProcedureTypeId = 2, Title = "Dont Care" }
                );

            modelBuilder.Entity<Equipment>()
                .HasData(
                    new Equipment { EquipmentId = 1, Title = "Surgery", Price = 100.99m },
                    new Equipment { EquipmentId = 2, Title = "PostMortem", Price = 80.99m }
                );

            modelBuilder.Entity<Room>()
                .HasData(
                    new Room { RoomId = 1, RoomNumber = "1230A" },
                    new Room { RoomId = 2, RoomNumber = "1234D" }
                );

            modelBuilder.Entity<Appointment>()
                .HasData(
                    new Appointment { AppointmentId = 1, StartTime = new DateTime(2022, 01, 01, 10, 30, 00), EndTime = new DateTime(2022, 01, 01, 11, 30, 00), DoctorId = 1, NurseId = 3, RoomId = 1, Status = Status.BOOKED },
                    new Appointment { AppointmentId = 2, StartTime = new DateTime(2023, 05, 07, 12, 30, 00, 00), EndTime = new DateTime(2023, 05, 07, 13, 30, 00), DoctorId = 2, NurseId = 4, RoomId = 2, Status = Status.AVAILABLE }
                );

            modelBuilder.Entity<Procedure>()
                .HasData(
                    new Procedure { ProcedureId = 1, AppointmentId = 1, ProcedureTypeId = 1, TreatmentId = 1 },
                    new Procedure { ProcedureId = 2, AppointmentId = 2, ProcedureTypeId = 2, TreatmentId = 2 }
                );

            modelBuilder.Entity<Procedure_Equipment>()
                .HasData(
                    new Procedure_Equipment { EquipmentId = 1, ProceureId = 1 },
                    new Procedure_Equipment { EquipmentId = 2, ProceureId = 2 }
                );

            modelBuilder.Entity<Medicine>()
                .HasData(
                    new Medicine { MedicineId = 1, ProcedureId = 1, Amount = 10, MedicineType = MedicineType.CAPSULE },
                    new Medicine { MedicineId = 2, ProcedureId = 2, Amount = 5, MedicineType = MedicineType.LIQUID }
                );

            modelBuilder.Entity<ExaminationType>()
                .HasData(
                    new ExaminationType { ExaminationTypeId = 1, Title = "Full" },
                    new ExaminationType { ExaminationTypeId = 2, Title = "Partial" }
                );

            modelBuilder.Entity<Examination>()
                .HasData(
                    new Examination { ExaminationId = 1, ExaminationTypeId = 1 },
                    new Examination { ExaminationId = 2, ExaminationTypeId = 2 }
                );

            modelBuilder.Entity<ExaminationDiagnosis>()
                .HasData(
                    new ExaminationDiagnosis { ExaminationId = 1, DiagnosisId = 1 },
                    new ExaminationDiagnosis { ExaminationId = 2, DiagnosisId = 2 }
                );
        }
    }
}
