using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace App.Persistance.Migrations
{
    /// <inheritdoc />
    public partial class FinalMigration : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Doctor_Medial_Staff_PersonId",
                table: "Doctor");

            migrationBuilder.DropForeignKey(
                name: "FK_Medial_Staff_Person_PersonId",
                table: "Medial_Staff");

            migrationBuilder.DropForeignKey(
                name: "FK_Nurse_Medial_Staff_PersonId",
                table: "Nurse");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Medial_Staff",
                table: "Medial_Staff");

            migrationBuilder.RenameTable(
                name: "Medial_Staff",
                newName: "Medical_Staff");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Medical_Staff",
                table: "Medical_Staff",
                column: "PersonId");

            migrationBuilder.AddForeignKey(
                name: "FK_Doctor_Medical_Staff_PersonId",
                table: "Doctor",
                column: "PersonId",
                principalTable: "Medical_Staff",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Medical_Staff_Person_PersonId",
                table: "Medical_Staff",
                column: "PersonId",
                principalTable: "Person",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Nurse_Medical_Staff_PersonId",
                table: "Nurse",
                column: "PersonId",
                principalTable: "Medical_Staff",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Doctor_Medical_Staff_PersonId",
                table: "Doctor");

            migrationBuilder.DropForeignKey(
                name: "FK_Medical_Staff_Person_PersonId",
                table: "Medical_Staff");

            migrationBuilder.DropForeignKey(
                name: "FK_Nurse_Medical_Staff_PersonId",
                table: "Nurse");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Medical_Staff",
                table: "Medical_Staff");

            migrationBuilder.RenameTable(
                name: "Medical_Staff",
                newName: "Medial_Staff");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Medial_Staff",
                table: "Medial_Staff",
                column: "PersonId");

            migrationBuilder.AddForeignKey(
                name: "FK_Doctor_Medial_Staff_PersonId",
                table: "Doctor",
                column: "PersonId",
                principalTable: "Medial_Staff",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Medial_Staff_Person_PersonId",
                table: "Medial_Staff",
                column: "PersonId",
                principalTable: "Person",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Nurse_Medial_Staff_PersonId",
                table: "Nurse",
                column: "PersonId",
                principalTable: "Medial_Staff",
                principalColumn: "PersonId",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
