﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Mp5.data;

#nullable disable

namespace Mp5.Migrations
{
    [DbContext(typeof(DataContext))]
    [Migration("20230318212636_Final")]
    partial class Final
    {
        /// <inheritdoc />
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder.HasAnnotation("ProductVersion", "7.0.4");

            modelBuilder.Entity("Mp5.models.Course", b =>
                {
                    b.Property<int>("CourseId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("INTEGER");

                    b.Property<int>("CourseMaterialId")
                        .HasColumnType("INTEGER");

                    b.Property<int>("Credits")
                        .HasColumnType("INTEGER");

                    b.Property<int>("TeacherId")
                        .HasColumnType("INTEGER");

                    b.Property<string>("Title")
                        .IsRequired()
                        .HasColumnType("TEXT");

                    b.HasKey("CourseId");

                    b.HasIndex("CourseMaterialId")
                        .IsUnique();

                    b.HasIndex("TeacherId");

                    b.ToTable("Course", (string)null);

                    b.HasData(
                        new
                        {
                            CourseId = 1,
                            CourseMaterialId = 1,
                            Credits = 7,
                            TeacherId = 1,
                            Title = "MAS"
                        },
                        new
                        {
                            CourseId = 2,
                            CourseMaterialId = 2,
                            Credits = 5,
                            TeacherId = 2,
                            Title = "SBD"
                        },
                        new
                        {
                            CourseId = 3,
                            CourseMaterialId = 3,
                            Credits = 7,
                            TeacherId = 3,
                            Title = "SOP"
                        });
                });

            modelBuilder.Entity("Mp5.models.CourseMaterial", b =>
                {
                    b.Property<int>("CourseMaterialId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("INTEGER");

                    b.Property<string>("Url")
                        .HasColumnType("TEXT");

                    b.HasKey("CourseMaterialId");

                    b.ToTable("Course_Material", (string)null);

                    b.HasData(
                        new
                        {
                            CourseMaterialId = 1,
                            Url = "https://anyuri1.com"
                        },
                        new
                        {
                            CourseMaterialId = 2,
                            Url = "https://anyuri2.com"
                        },
                        new
                        {
                            CourseMaterialId = 3,
                            Url = "https://anyuri3.com"
                        });
                });

            modelBuilder.Entity("Mp5.models.Person", b =>
                {
                    b.Property<int>("PersonId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("INTEGER");

                    b.Property<string>("Email")
                        .HasColumnType("TEXT");

                    b.Property<string>("FirstName")
                        .IsRequired()
                        .HasColumnType("TEXT");

                    b.Property<string>("LastName")
                        .IsRequired()
                        .HasColumnType("TEXT");

                    b.HasKey("PersonId");

                    b.ToTable("Person", (string)null);

                    b.UseTptMappingStrategy();
                });

            modelBuilder.Entity("Mp5.models.StudentCourse", b =>
                {
                    b.Property<int>("StudentCourseId")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("INTEGER");

                    b.Property<int>("CourseId")
                        .HasColumnType("INTEGER");

                    b.Property<int>("StudentId")
                        .HasColumnType("INTEGER");

                    b.HasKey("StudentCourseId");

                    b.HasIndex("CourseId");

                    b.HasIndex("StudentId");

                    b.ToTable("Student_Course", (string)null);

                    b.HasData(
                        new
                        {
                            StudentCourseId = 1,
                            CourseId = 1,
                            StudentId = 4
                        },
                        new
                        {
                            StudentCourseId = 2,
                            CourseId = 2,
                            StudentId = 4
                        },
                        new
                        {
                            StudentCourseId = 3,
                            CourseId = 2,
                            StudentId = 5
                        },
                        new
                        {
                            StudentCourseId = 4,
                            CourseId = 3,
                            StudentId = 6
                        });
                });

            modelBuilder.Entity("Mp5.models.Student", b =>
                {
                    b.HasBaseType("Mp5.models.Person");

                    b.Property<DateTime>("EnrollmentDate")
                        .HasColumnType("TEXT");

                    b.ToTable("Student", (string)null);

                    b.HasData(
                        new
                        {
                            PersonId = 4,
                            Email = "flash@test.com",
                            FirstName = "Barry",
                            LastName = "Allen",
                            EnrollmentDate = new DateTime(2020, 2, 14, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        },
                        new
                        {
                            PersonId = 5,
                            Email = "batman@test.com",
                            FirstName = "Bruce",
                            LastName = "Wayne",
                            EnrollmentDate = new DateTime(2021, 4, 2, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        },
                        new
                        {
                            PersonId = 6,
                            Email = "superman@test.com",
                            FirstName = "Clark",
                            LastName = "Kent",
                            EnrollmentDate = new DateTime(2023, 1, 9, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        });
                });

            modelBuilder.Entity("Mp5.models.Teacher", b =>
                {
                    b.HasBaseType("Mp5.models.Person");

                    b.Property<DateTime>("HireDate")
                        .HasColumnType("TEXT");

                    b.ToTable("Teacher", (string)null);

                    b.HasData(
                        new
                        {
                            PersonId = 1,
                            Email = "cap@test.com",
                            FirstName = "Steve",
                            LastName = "Rogers",
                            HireDate = new DateTime(2019, 8, 23, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        },
                        new
                        {
                            PersonId = 2,
                            Email = "ironman@test.com",
                            FirstName = "Tony",
                            LastName = "Stark",
                            HireDate = new DateTime(2009, 11, 13, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        },
                        new
                        {
                            PersonId = 3,
                            Email = "fury@test.com",
                            FirstName = "Nick",
                            LastName = "Fury",
                            HireDate = new DateTime(2019, 5, 3, 0, 0, 0, 0, DateTimeKind.Unspecified)
                        });
                });

            modelBuilder.Entity("Mp5.models.Course", b =>
                {
                    b.HasOne("Mp5.models.CourseMaterial", "CourseMaterial")
                        .WithOne("Course")
                        .HasForeignKey("Mp5.models.Course", "CourseMaterialId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("Mp5.models.Teacher", "Teacher")
                        .WithMany("Courses")
                        .HasForeignKey("TeacherId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("CourseMaterial");

                    b.Navigation("Teacher");
                });

            modelBuilder.Entity("Mp5.models.StudentCourse", b =>
                {
                    b.HasOne("Mp5.models.Course", "Course")
                        .WithMany("StudentCourses")
                        .HasForeignKey("CourseId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("Mp5.models.Student", "Student")
                        .WithMany("StudentCourses")
                        .HasForeignKey("StudentId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Course");

                    b.Navigation("Student");
                });

            modelBuilder.Entity("Mp5.models.Student", b =>
                {
                    b.HasOne("Mp5.models.Person", null)
                        .WithOne()
                        .HasForeignKey("Mp5.models.Student", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();
                });

            modelBuilder.Entity("Mp5.models.Teacher", b =>
                {
                    b.HasOne("Mp5.models.Person", null)
                        .WithOne()
                        .HasForeignKey("Mp5.models.Teacher", "PersonId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();
                });

            modelBuilder.Entity("Mp5.models.Course", b =>
                {
                    b.Navigation("StudentCourses");
                });

            modelBuilder.Entity("Mp5.models.CourseMaterial", b =>
                {
                    b.Navigation("Course");
                });

            modelBuilder.Entity("Mp5.models.Student", b =>
                {
                    b.Navigation("StudentCourses");
                });

            modelBuilder.Entity("Mp5.models.Teacher", b =>
                {
                    b.Navigation("Courses");
                });
#pragma warning restore 612, 618
        }
    }
}
