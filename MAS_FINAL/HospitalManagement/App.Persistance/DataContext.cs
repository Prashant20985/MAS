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
        public DbSet<Examination_Diagnosis> Examination_Diagnoses { get; set; }
        public DbSet<ExaminationType> ExaminationTypes { get; set; }
        public DbSet<Doctor_Specialization> Doctor_Specializations { get; set; }
        public DbSet<Nurse_Certification> Nurse_Certifications { get; set; }
        public DbSet<Allergy> Allergies { get; set; }
        public DbSet<PatientAllergy> PatientAllergies { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Procedure_Equipment>()
                .HasKey(x => new { x.EquipmentId, x.ProcedureId });

            modelBuilder.Entity<Examination_Diagnosis>()
                .HasKey(x => new { x.DiagnosisId, x.ExaminationId });

            modelBuilder.Entity<Nurse_Certification>()
                .HasKey(x => new { x.NurseId, x.CertificationId });

            modelBuilder.Entity<Doctor_Specialization>()
                .HasKey(x => new { x.DoctorId, x.SpecializationId });

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Procedure)
                .WithOne(x => x.Appointment)
                .HasForeignKey<Procedure>(y => y.AppointmentId);

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Examination)
                .WithOne(y => y.Appointment)
                .HasForeignKey<Examination>(z => z.AppointmentId);

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Patient)
                .WithMany(y => y.Appointments)
                .HasForeignKey(z => z.PatientId)
                .OnDelete(DeleteBehavior.NoAction);

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Nurse)
                .WithMany(y => y.Appointments)
                .HasForeignKey(z => z.NurseId)
                .OnDelete(DeleteBehavior.NoAction);

            modelBuilder.Entity<Appointment>()
                .HasOne(x => x.Doctor)
                .WithMany(x => x.Appointments)
                .HasForeignKey(z => z.DoctorId)
                .OnDelete(DeleteBehavior.NoAction);

            // Unique
            modelBuilder.Entity<Patient>()
                .HasIndex(x => x.InsuranceNumber)
                .IsUnique();

            // Composition 
            modelBuilder.Entity<Medicine>()
                .HasOne(x => x.Procedure)
                .WithMany(y => y.Medicines)
                .HasForeignKey(z => z.ProcedureId)
                .OnDelete(DeleteBehavior.Cascade);

            // Multi_val
            modelBuilder.Entity<Patient>()
                .HasMany(p => p.Allergies)
                .WithMany()
                .UsingEntity<PatientAllergy>(
                j => j
                    .HasOne<Allergy>()
                    .WithMany()
                    .HasForeignKey(x => x.AllergyId),
                j => j
                    .HasOne<Patient>()
                    .WithMany()
                    .HasForeignKey(y => y.PatientId),
                j =>
                {
                    j.HasKey(z => new {z.AllergyId, z.PatientId});
                    j.ToTable("PatientAllergy");
                }
            );

            // Seed Data
            modelBuilder.Entity<Specialization>()
                .HasData(
                    new Specialization { SpecializationId = 1, Title = "Dentistry" },
                    new Specialization { SpecializationId = 2, Title = "Cardiology" }
                );

            modelBuilder.Entity<Certification>()
                .HasData(
                    new Certification { CertificationId = 1, Title = "any title" },
                    new Certification { CertificationId = 2, Title = "any title" }
                );

            modelBuilder.Entity<Diagnosis>()
                .HasData(
                    new Diagnosis { DiagnosisId = 1, Title = "Kemo", DateDiagnosed = new DateTime(2022, 01, 01, 10, 30, 00) },
                    new Diagnosis { DiagnosisId = 2, Title = "ECG", DateDiagnosed = new DateTime(2022, 01, 01, 10, 30, 00) }
                );

            var doctor1 = new Doctor { PersonId = 1, FirstName = "Bruce", LastName = "Wayne", DateOfBirth = new DateTime(2000, 01, 01), Gender = Gender.MALE, RatePerHour = 100.00F, BonusPerAppointment = 10 };
            doctor1.calculateSalary();
            var doctor2 = new Doctor { PersonId = 2, FirstName = "Clark", LastName = "Kent", DateOfBirth = new DateTime(1999, 05, 05), Gender = Gender.MALE, RatePerHour = 150.99F };
            doctor2.calculateSalary();

            modelBuilder.Entity<Doctor>()
                .HasData(doctor1, doctor2);

            var nurse1 = new Nurse { PersonId = 3, FirstName = "Dianna", LastName = "Price", DateOfBirth = new DateTime(1998, 05, 05), Gender = Gender.FEMALE, RatePerHour = 90.99F };
            nurse1.calculateSalary();
            var nurse2 = new Nurse { PersonId = 4, FirstName = "Barry", LastName = "Allen", DateOfBirth = new DateTime(1998, 05, 05), Gender = Gender.MALE, RatePerHour = 90.99F };
            nurse2.calculateSalary();

            modelBuilder.Entity<Nurse>()
                .HasData(nurse1, nurse2);

            modelBuilder.Entity<Nurse_Certification>()
                .HasData(
                    new Nurse_Certification { NurseId = 3, CertificationId = 1 },
                    new Nurse_Certification { NurseId = 4, CertificationId = 1 },
                    new Nurse_Certification { NurseId = 4, CertificationId = 2 }
                );

            modelBuilder.Entity<Doctor_Specialization>()
                .HasData(
                    new Doctor_Specialization { DoctorId = 1, SpecializationId = 1 },
                    new Doctor_Specialization { DoctorId = 2, SpecializationId = 2 }
                );

            modelBuilder.Entity<Allergy>().HasData(new Allergy { Id = 1, Name = "qwer" });

            modelBuilder.Entity<Patient>()
                .HasData(
                    new Patient { PersonId = 5, FirstName = "Victor", LastName = "Stone", DateOfBirth = new DateTime(2002, 08, 08), Gender = Gender.MALE, InsuranceNumber = 12365478 },
                    new Patient { PersonId = 6, FirstName = "Arthur", LastName = "Curry", DateOfBirth = new DateTime(2002, 08, 08), Gender = Gender.FEMALE, InsuranceNumber = 12365008 }
                );

            modelBuilder.Entity<PatientAllergy>()
                 .HasData(new PatientAllergy { PatientId = 5, AllergyId = 1 });

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
                    new Equipment { EquipmentId = 1, Title = "Surgery", PricePerProcedure = 100.99F },
                    new Equipment { EquipmentId = 2, Title = "PostMortem", PricePerProcedure = 80.99F }
                );

            modelBuilder.Entity<Room>()
                .HasData(
                    new Room { RoomId = 1, RoomNumber = "1230A" },
                    new Room { RoomId = 2, RoomNumber = "1234D" }
                );

            modelBuilder.Entity<Appointment>()
                .HasData(
                    new Appointment { AppointmentId = 1, PatientId = 5, StartTime = new DateTime(2022, 01, 01, 10, 30, 00), EndTime = new DateTime(2022, 01, 01, 11, 30, 00), DoctorId = 1, NurseId = 3, RoomId = 1, Status = Status.BOOKED, AppointmentCost = 120 },
                    new Appointment { AppointmentId = 2, PatientId = 6, StartTime = new DateTime(2023, 05, 07, 12, 30, 00, 00), EndTime = new DateTime(2023, 05, 07, 13, 30, 00), DoctorId = 2, NurseId = 4, RoomId = 2, Status = Status.AVAILABLE, AppointmentCost = 100 },
                    new Appointment { AppointmentId = 3, PatientId = 5, StartTime = new DateTime(2023, 05, 07, 12, 30, 00, 00), EndTime = new DateTime(2023, 05, 07, 13, 30, 00), DoctorId = 2, NurseId = 4, RoomId = 2, Status = Status.AVAILABLE, AppointmentCost = 100 }
                );

            modelBuilder.Entity<Procedure>()
                .HasData(
                    new Procedure { ProcedureId = 1, AppointmentId = 1, ProcedureTypeId = 1, TreatmentId = 1 },
                    new Procedure { ProcedureId = 2, AppointmentId = 2, ProcedureTypeId = 2, TreatmentId = 2 }
                );

            modelBuilder.Entity<Procedure_Equipment>()
                .HasData(
                    new Procedure_Equipment { EquipmentId = 1, ProcedureId = 1 },
                    new Procedure_Equipment { EquipmentId = 2, ProcedureId = 2 }
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
                    new Examination { ExaminationId = 1, ExaminationTypeId = 1, AppointmentId = 1 },
                    new Examination { ExaminationId = 2, ExaminationTypeId = 2, AppointmentId = 2 }
                );

            modelBuilder.Entity<Examination_Diagnosis>()
                .HasData(
                    new Examination_Diagnosis { ExaminationId = 1, DiagnosisId = 1 },
                    new Examination_Diagnosis { ExaminationId = 2, DiagnosisId = 2 }
                );
        }
    }
}
