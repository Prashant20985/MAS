using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace App.Persistance.Migrations
{
    /// <inheritdoc />
    public partial class SeedData : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Certification",
                columns: new[] { "CertificationId", "Title" },
                values: new object[,]
                {
                    { 1, "any title" },
                    { 2, "any title" }
                });

            migrationBuilder.InsertData(
                table: "Diagnosis",
                columns: new[] { "DiagnosisId", "Title" },
                values: new object[,]
                {
                    { 1, "Kemo" },
                    { 2, "ECG" }
                });

            migrationBuilder.InsertData(
                table: "Equipment",
                columns: new[] { "EquipmentId", "Price", "Title" },
                values: new object[,]
                {
                    { 1, 100.99m, "Surgery" },
                    { 2, 80.99m, "PostMortem" }
                });

            migrationBuilder.InsertData(
                table: "ExaminationType",
                columns: new[] { "ExaminationTypeId", "Title" },
                values: new object[,]
                {
                    { 1, "Full" },
                    { 2, "Partial" }
                });

            migrationBuilder.InsertData(
                table: "Person",
                columns: new[] { "PersonId", "DateOfBirth", "FirstName", "Gender", "LastName" },
                values: new object[,]
                {
                    { 1, new DateTime(2000, 1, 1, 0, 0, 0, 0, DateTimeKind.Unspecified), "Bruce", "MALE", "Wayne" },
                    { 2, new DateTime(1999, 5, 1, 0, 0, 0, 0, DateTimeKind.Unspecified), "Clark", "MALE", "Kent" },
                    { 3, new DateTime(1998, 5, 7, 0, 0, 0, 0, DateTimeKind.Unspecified), "Dianna", "FEMALE", "Price" },
                    { 4, new DateTime(1998, 5, 8, 0, 0, 0, 0, DateTimeKind.Unspecified), "Barry", "MALE", "Allen" },
                    { 5, new DateTime(2002, 8, 22, 0, 0, 0, 0, DateTimeKind.Unspecified), "Victor", "MALE", "Stone" },
                    { 6, new DateTime(2002, 8, 26, 0, 0, 0, 0, DateTimeKind.Unspecified), "Arthur", "FEMALE", "Curry" }
                });

            migrationBuilder.InsertData(
                table: "ProcedureType",
                columns: new[] { "ProcedureTypeId", "Title" },
                values: new object[,]
                {
                    { 1, "Dont Know" },
                    { 2, "Dont Care" }
                });

            migrationBuilder.InsertData(
                table: "Room",
                columns: new[] { "RoomId", "RoomNumber" },
                values: new object[,]
                {
                    { 1, "1230A" },
                    { 2, "1234D" }
                });

            migrationBuilder.InsertData(
                table: "Specialization",
                columns: new[] { "SecializationId", "Title" },
                values: new object[,]
                {
                    { 1, "Dentistry" },
                    { 2, "Cardiology" }
                });

            migrationBuilder.InsertData(
                table: "Examination",
                columns: new[] { "ExaminationId", "ExaminationTypeId" },
                values: new object[,]
                {
                    { 1, 1 },
                    { 2, 2 }
                });

            migrationBuilder.InsertData(
                table: "Medial_Staff",
                columns: new[] { "PersonId", "ratePerHour" },
                values: new object[,]
                {
                    { 1, 100.00m },
                    { 2, 150.99m },
                    { 3, 90.99m },
                    { 4, 90.99m }
                });

            migrationBuilder.InsertData(
                table: "Patient",
                columns: new[] { "PersonId", "DiagnosisId", "InsuranceNumber" },
                values: new object[,]
                {
                    { 5, 1, 12365478L },
                    { 6, 2, 12365008L }
                });

            migrationBuilder.InsertData(
                table: "Treatment",
                columns: new[] { "TreatmentId", "DiagnosisId", "Title" },
                values: new object[,]
                {
                    { 1, 1, "Main" },
                    { 2, 2, "Secondry" }
                });

            migrationBuilder.InsertData(
                table: "Doctor",
                columns: new[] { "PersonId", "SpecializationId" },
                values: new object[,]
                {
                    { 1, 1 },
                    { 2, 2 }
                });

            migrationBuilder.InsertData(
                table: "ExaminationDiagnosis",
                columns: new[] { "DiagnosisId", "ExaminationId" },
                values: new object[,]
                {
                    { 1, 1 },
                    { 2, 2 }
                });

            migrationBuilder.InsertData(
                table: "Nurse",
                columns: new[] { "PersonId", "CertificationId" },
                values: new object[,]
                {
                    { 3, 1 },
                    { 4, 2 }
                });

            migrationBuilder.InsertData(
                table: "Appointment",
                columns: new[] { "AppointmentId", "DoctorId", "EndTime", "NurseId", "RoomId", "StartTime", "Status" },
                values: new object[,]
                {
                    { 1, 1, new DateTime(2022, 1, 1, 11, 30, 0, 0, DateTimeKind.Unspecified), 3, 1, new DateTime(2022, 1, 1, 10, 30, 0, 0, DateTimeKind.Unspecified), "BOOKED" },
                    { 2, 2, new DateTime(2023, 5, 7, 13, 30, 0, 0, DateTimeKind.Unspecified), 4, 2, new DateTime(2023, 5, 7, 12, 30, 0, 0, DateTimeKind.Unspecified), "AVAILABLE" }
                });

            migrationBuilder.InsertData(
                table: "Procedure",
                columns: new[] { "ProcedureId", "AppointmentId", "ProcedureTypeId", "TreatmentId" },
                values: new object[,]
                {
                    { 1, 1, 1, 1 },
                    { 2, 2, 2, 2 }
                });

            migrationBuilder.InsertData(
                table: "Medicine",
                columns: new[] { "MedicineId", "Amount", "MedicineType", "ProcedureId" },
                values: new object[,]
                {
                    { 1, 10, "CAPSULE", 1 },
                    { 2, 5, "LIQUID", 2 }
                });

            migrationBuilder.InsertData(
                table: "Procedure_Equipment",
                columns: new[] { "EquipmentId", "ProceureId" },
                values: new object[,]
                {
                    { 1, 1 },
                    { 2, 2 }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "ExaminationDiagnosis",
                keyColumns: new[] { "DiagnosisId", "ExaminationId" },
                keyValues: new object[] { 1, 1 });

            migrationBuilder.DeleteData(
                table: "ExaminationDiagnosis",
                keyColumns: new[] { "DiagnosisId", "ExaminationId" },
                keyValues: new object[] { 2, 2 });

            migrationBuilder.DeleteData(
                table: "Medicine",
                keyColumn: "MedicineId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Medicine",
                keyColumn: "MedicineId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Patient",
                keyColumn: "PersonId",
                keyValue: 5);

            migrationBuilder.DeleteData(
                table: "Patient",
                keyColumn: "PersonId",
                keyValue: 6);

            migrationBuilder.DeleteData(
                table: "Procedure_Equipment",
                keyColumns: new[] { "EquipmentId", "ProceureId" },
                keyValues: new object[] { 1, 1 });

            migrationBuilder.DeleteData(
                table: "Procedure_Equipment",
                keyColumns: new[] { "EquipmentId", "ProceureId" },
                keyValues: new object[] { 2, 2 });

            migrationBuilder.DeleteData(
                table: "Equipment",
                keyColumn: "EquipmentId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Equipment",
                keyColumn: "EquipmentId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Examination",
                keyColumn: "ExaminationId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Examination",
                keyColumn: "ExaminationId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 5);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 6);

            migrationBuilder.DeleteData(
                table: "Procedure",
                keyColumn: "ProcedureId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Procedure",
                keyColumn: "ProcedureId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Appointment",
                keyColumn: "AppointmentId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Appointment",
                keyColumn: "AppointmentId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "ExaminationType",
                keyColumn: "ExaminationTypeId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "ExaminationType",
                keyColumn: "ExaminationTypeId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "ProcedureType",
                keyColumn: "ProcedureTypeId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "ProcedureType",
                keyColumn: "ProcedureTypeId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Treatment",
                keyColumn: "TreatmentId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Treatment",
                keyColumn: "TreatmentId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Diagnosis",
                keyColumn: "DiagnosisId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Diagnosis",
                keyColumn: "DiagnosisId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Doctor",
                keyColumn: "PersonId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Doctor",
                keyColumn: "PersonId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Nurse",
                keyColumn: "PersonId",
                keyValue: 3);

            migrationBuilder.DeleteData(
                table: "Nurse",
                keyColumn: "PersonId",
                keyValue: 4);

            migrationBuilder.DeleteData(
                table: "Room",
                keyColumn: "RoomId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Room",
                keyColumn: "RoomId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Certification",
                keyColumn: "CertificationId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Certification",
                keyColumn: "CertificationId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Medial_Staff",
                keyColumn: "PersonId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Medial_Staff",
                keyColumn: "PersonId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Medial_Staff",
                keyColumn: "PersonId",
                keyValue: 3);

            migrationBuilder.DeleteData(
                table: "Medial_Staff",
                keyColumn: "PersonId",
                keyValue: 4);

            migrationBuilder.DeleteData(
                table: "Specialization",
                keyColumn: "SecializationId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Specialization",
                keyColumn: "SecializationId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 3);

            migrationBuilder.DeleteData(
                table: "Person",
                keyColumn: "PersonId",
                keyValue: 4);
        }
    }
}
