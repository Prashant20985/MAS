﻿// <auto-generated />
using System;
using App.Persistance;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

#nullable disable

namespace App.Persistance.Migrations
{
    [DbContext(typeof(DataContext))]
    [Migration("20230503164320_InitialMigration")]
    partial class InitialMigration
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "7.0.4")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder);

            modelBuilder.Entity("App.Domain.Models.Appointment", b =>
                {
                    b.Property<int>("AppointmentId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("AppointmentId"));

                    b.Property<int>("DoctorId")
                        .HasColumnType("int");

                    b.Property<DateTime>("EndTime")
                        .HasColumnType("datetime2");

                    b.Property<int>("NurseId")
                        .HasColumnType("int");

                    b.Property<int>("RoomId")
                        .HasColumnType("int");

                    b.Property<DateTime>("StartTime")
                        .HasColumnType("datetime2");

                    b.Property<string>("Status")
                        .IsRequired()
                        .HasColumnType("nvarchar(10)");

                    b.HasKey("AppointmentId");

                    b.HasIndex("DoctorId");

                    b.HasIndex("NurseId");

                    b.HasIndex("RoomId");

                    b.ToTable("Appointment");
                });

            modelBuilder.Entity("App.Domain.Models.Cerification", b =>
                {
                    b.Property<int>("CertificationId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("CertificationId"));

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(100)
                        .HasColumnType("nvarchar(100)");

                    b.HasKey("CertificationId");

                    b.ToTable("Certification");
                });

            modelBuilder.Entity("App.Domain.Models.Diagnosis", b =>
                {
                    b.Property<int>("DiagnosisId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("DiagnosisId"));

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(100)
                        .HasColumnType("nvarchar(100)");

                    b.HasKey("DiagnosisId");

                    b.ToTable("Diagnosis");
                });

            modelBuilder.Entity("App.Domain.Models.Equipment", b =>
                {
                    b.Property<int>("EquipmentId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("EquipmentId"));

                    b.Property<decimal>("Price")
                        .HasColumnType("decimal(18,2)");

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(100)
                        .HasColumnType("nvarchar(100)");

                    b.HasKey("EquipmentId");

                    b.ToTable("Equipment");
                });

            modelBuilder.Entity("App.Domain.Models.Examination", b =>
                {
                    b.Property<int>("ExaminationId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("ExaminationId"));

                    b.Property<int>("ExaminationTypeId")
                        .HasColumnType("int");

                    b.HasKey("ExaminationId");

                    b.HasIndex("ExaminationTypeId");

                    b.ToTable("Examination");
                });

            modelBuilder.Entity("App.Domain.Models.ExaminationDiagnosis", b =>
                {
                    b.Property<int>("DiagnosisId")
                        .HasColumnType("int");

                    b.Property<int>("ExaminationId")
                        .HasColumnType("int");

                    b.HasKey("DiagnosisId", "ExaminationId");

                    b.HasIndex("ExaminationId");

                    b.ToTable("ExaminationDiagnosis");
                });

            modelBuilder.Entity("App.Domain.Models.ExaminationType", b =>
                {
                    b.Property<int>("ExaminationTypeId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("ExaminationTypeId"));

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(20)
                        .HasColumnType("nvarchar(20)");

                    b.HasKey("ExaminationTypeId");

                    b.ToTable("ExaminationType");
                });

            modelBuilder.Entity("App.Domain.Models.Medicine", b =>
                {
                    b.Property<int>("MedicineId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("MedicineId"));

                    b.Property<int>("Amount")
                        .HasColumnType("int");

                    b.Property<string>("MedicineType")
                        .IsRequired()
                        .HasColumnType("nvarchar(20)");

                    b.Property<int>("ProcedureId")
                        .HasColumnType("int");

                    b.HasKey("MedicineId");

                    b.HasIndex("ProcedureId");

                    b.ToTable("Medicine");
                });

            modelBuilder.Entity("App.Domain.Models.Person", b =>
                {
                    b.Property<int>("PersonId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("PersonId"));

                    b.Property<DateTime>("DateOfBirth")
                        .HasColumnType("datetime2");

                    b.Property<string>("FirstName")
                        .IsRequired()
                        .HasMaxLength(30)
                        .HasColumnType("nvarchar(30)");

                    b.Property<string>("Gender")
                        .IsRequired()
                        .HasColumnType("nvarchar(6)");

                    b.Property<string>("LastName")
                        .IsRequired()
                        .HasMaxLength(30)
                        .HasColumnType("nvarchar(30)");

                    b.HasKey("PersonId");

                    b.ToTable("Person");

                    b.UseTptMappingStrategy();
                });

            modelBuilder.Entity("App.Domain.Models.Procedure", b =>
                {
                    b.Property<int>("ProcedureId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("ProcedureId"));

                    b.Property<int>("AppointmentId")
                        .HasColumnType("int");

                    b.Property<int>("ProcedureTypeId")
                        .HasColumnType("int");

                    b.Property<int>("TreatmentId")
                        .HasColumnType("int");

                    b.HasKey("ProcedureId");

                    b.HasIndex("AppointmentId");

                    b.HasIndex("ProcedureTypeId");

                    b.HasIndex("TreatmentId");

                    b.ToTable("Procedure");
                });

            modelBuilder.Entity("App.Domain.Models.ProcedureType", b =>
                {
                    b.Property<int>("ProcedureTypeId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("ProcedureTypeId"));

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(100)
                        .HasColumnType("nvarchar(100)");

                    b.HasKey("ProcedureTypeId");

                    b.ToTable("ProcedureType");
                });

            modelBuilder.Entity("App.Domain.Models.Procedure_Equipment", b =>
                {
                    b.Property<int>("EquipmentId")
                        .HasColumnType("int");

                    b.Property<int>("ProceureId")
                        .HasColumnType("int");

                    b.HasKey("EquipmentId", "ProceureId");

                    b.HasIndex("ProceureId");

                    b.ToTable("Procedure_Equipment");
                });

            modelBuilder.Entity("App.Domain.Models.Room", b =>
                {
                    b.Property<int>("RoomId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("RoomId"));

                    b.Property<string>("RoomNumber")
                        .IsRequired()
                        .HasMaxLength(5)
                        .HasColumnType("nvarchar(5)");

                    b.HasKey("RoomId");

                    b.ToTable("Room");
                });

            modelBuilder.Entity("App.Domain.Models.Specialization", b =>
                {
                    b.Property<int>("SecializationId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("SecializationId"));

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(100)
                        .HasColumnType("nvarchar(100)");

                    b.HasKey("SecializationId");

                    b.ToTable("Specialization");
                });

            modelBuilder.Entity("App.Domain.Models.Treatment", b =>
                {
                    b.Property<int>("TreatmentId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("TreatmentId"));

                    b.Property<int>("DiagnosisId")
                        .HasColumnType("int");

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasMaxLength(30)
                        .HasColumnType("nvarchar(30)");

                    b.HasKey("TreatmentId");

                    b.HasIndex("DiagnosisId");

                    b.ToTable("Treatment");
                });

            modelBuilder.Entity("App.Domain.Models.MedicalStaff", b =>
                {
                    b.HasBaseType("App.Domain.Models.Person");

                    b.Property<decimal>("ratePerHour")
                        .HasColumnType("decimal(18,2)");

                    b.ToTable("Medial_Staff");
                });

            modelBuilder.Entity("App.Domain.Models.Patient", b =>
                {
                    b.HasBaseType("App.Domain.Models.Person");

                    b.Property<int>("DiagnosisId")
                        .HasColumnType("int");

                    b.Property<long>("InsuranceNumber")
                        .HasColumnType("bigint");

                    b.HasIndex("DiagnosisId");

                    b.ToTable("Patient");
                });

            modelBuilder.Entity("App.Domain.Models.Doctor", b =>
                {
                    b.HasBaseType("App.Domain.Models.MedicalStaff");

                    b.Property<int>("SpecializationId")
                        .HasColumnType("int");

                    b.HasIndex("SpecializationId");

                    b.ToTable("Doctor");
                });

            modelBuilder.Entity("App.Domain.Models.Nurse", b =>
                {
                    b.HasBaseType("App.Domain.Models.MedicalStaff");

                    b.Property<int>("CertificationId")
                        .HasColumnType("int");

                    b.HasIndex("CertificationId");

                    b.ToTable("Nurse");
                });

            modelBuilder.Entity("App.Domain.Models.Appointment", b =>
                {
                    b.HasOne("App.Domain.Models.Doctor", "Doctor")
                        .WithMany("Appointments")
                        .HasForeignKey("DoctorId")
                        .OnDelete(DeleteBehavior.NoAction)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Nurse", "Nurse")
                        .WithMany("Appointments")
                        .HasForeignKey("NurseId")
                        .OnDelete(DeleteBehavior.NoAction)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Room", "Room")
                        .WithMany("Appointments")
                        .HasForeignKey("RoomId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Doctor");

                    b.Navigation("Nurse");

                    b.Navigation("Room");
                });

            modelBuilder.Entity("App.Domain.Models.Examination", b =>
                {
                    b.HasOne("App.Domain.Models.ExaminationType", "ExaminationType")
                        .WithMany("Examinations")
                        .HasForeignKey("ExaminationTypeId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("ExaminationType");
                });

            modelBuilder.Entity("App.Domain.Models.ExaminationDiagnosis", b =>
                {
                    b.HasOne("App.Domain.Models.Diagnosis", "Diagnosis")
                        .WithMany("ExaminationDiagnoses")
                        .HasForeignKey("DiagnosisId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Examination", "Examination")
                        .WithMany("ExaminationDiagnoses")
                        .HasForeignKey("ExaminationId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Diagnosis");

                    b.Navigation("Examination");
                });

            modelBuilder.Entity("App.Domain.Models.Medicine", b =>
                {
                    b.HasOne("App.Domain.Models.Procedure", "Procedure")
                        .WithMany("Medicines")
                        .HasForeignKey("ProcedureId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Procedure");
                });

            modelBuilder.Entity("App.Domain.Models.Procedure", b =>
                {
                    b.HasOne("App.Domain.Models.Appointment", "Appointment")
                        .WithMany("Procedures")
                        .HasForeignKey("AppointmentId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.ProcedureType", "ProcedureType")
                        .WithMany("Procedures")
                        .HasForeignKey("ProcedureTypeId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Treatment", "Treatment")
                        .WithMany("Procedures")
                        .HasForeignKey("TreatmentId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Appointment");

                    b.Navigation("ProcedureType");

                    b.Navigation("Treatment");
                });

            modelBuilder.Entity("App.Domain.Models.Procedure_Equipment", b =>
                {
                    b.HasOne("App.Domain.Models.Equipment", "Equipment")
                        .WithMany("Procedure_Equipment")
                        .HasForeignKey("EquipmentId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Procedure", "Procedure")
                        .WithMany("Procedure_Equipment")
                        .HasForeignKey("ProceureId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Equipment");

                    b.Navigation("Procedure");
                });

            modelBuilder.Entity("App.Domain.Models.Treatment", b =>
                {
                    b.HasOne("App.Domain.Models.Diagnosis", "Diagnosis")
                        .WithMany("Treatments")
                        .HasForeignKey("DiagnosisId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Diagnosis");
                });

            modelBuilder.Entity("App.Domain.Models.MedicalStaff", b =>
                {
                    b.HasOne("App.Domain.Models.Person", null)
                        .WithOne()
                        .HasForeignKey("App.Domain.Models.MedicalStaff", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();
                });

            modelBuilder.Entity("App.Domain.Models.Patient", b =>
                {
                    b.HasOne("App.Domain.Models.Diagnosis", "Diagnosis")
                        .WithMany("Patients")
                        .HasForeignKey("DiagnosisId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Person", null)
                        .WithOne()
                        .HasForeignKey("App.Domain.Models.Patient", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Diagnosis");
                });

            modelBuilder.Entity("App.Domain.Models.Doctor", b =>
                {
                    b.HasOne("App.Domain.Models.MedicalStaff", null)
                        .WithOne()
                        .HasForeignKey("App.Domain.Models.Doctor", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.Specialization", "Specialization")
                        .WithMany("Doctors")
                        .HasForeignKey("SpecializationId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Specialization");
                });

            modelBuilder.Entity("App.Domain.Models.Nurse", b =>
                {
                    b.HasOne("App.Domain.Models.Cerification", "Cerification")
                        .WithMany("Nurses")
                        .HasForeignKey("CertificationId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("App.Domain.Models.MedicalStaff", null)
                        .WithOne()
                        .HasForeignKey("App.Domain.Models.Nurse", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Cerification");
                });

            modelBuilder.Entity("App.Domain.Models.Appointment", b =>
                {
                    b.Navigation("Procedures");
                });

            modelBuilder.Entity("App.Domain.Models.Cerification", b =>
                {
                    b.Navigation("Nurses");
                });

            modelBuilder.Entity("App.Domain.Models.Diagnosis", b =>
                {
                    b.Navigation("ExaminationDiagnoses");

                    b.Navigation("Patients");

                    b.Navigation("Treatments");
                });

            modelBuilder.Entity("App.Domain.Models.Equipment", b =>
                {
                    b.Navigation("Procedure_Equipment");
                });

            modelBuilder.Entity("App.Domain.Models.Examination", b =>
                {
                    b.Navigation("ExaminationDiagnoses");
                });

            modelBuilder.Entity("App.Domain.Models.ExaminationType", b =>
                {
                    b.Navigation("Examinations");
                });

            modelBuilder.Entity("App.Domain.Models.Procedure", b =>
                {
                    b.Navigation("Medicines");

                    b.Navigation("Procedure_Equipment");
                });

            modelBuilder.Entity("App.Domain.Models.ProcedureType", b =>
                {
                    b.Navigation("Procedures");
                });

            modelBuilder.Entity("App.Domain.Models.Room", b =>
                {
                    b.Navigation("Appointments");
                });

            modelBuilder.Entity("App.Domain.Models.Specialization", b =>
                {
                    b.Navigation("Doctors");
                });

            modelBuilder.Entity("App.Domain.Models.Treatment", b =>
                {
                    b.Navigation("Procedures");
                });

            modelBuilder.Entity("App.Domain.Models.Doctor", b =>
                {
                    b.Navigation("Appointments");
                });

            modelBuilder.Entity("App.Domain.Models.Nurse", b =>
                {
                    b.Navigation("Appointments");
                });
#pragma warning restore 612, 618
        }
    }
}
