﻿using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace LaudoPro.Infrastructure.Migrations
{
    /// <inheritdoc />
    public partial class First : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "plans",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    type = table.Column<int>(type: "INTEGER", nullable: false),
                    Price = table.Column<double>(type: "REAL", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_plans", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "pressure_gauge",
                columns: table => new
                {
                    uuid = table.Column<string>(type: "TEXT", nullable: false),
                    resolution = table.Column<string>(type: "TEXT", maxLength: 50, nullable: false),
                    tolerance = table.Column<string>(type: "TEXT", maxLength: 200, nullable: false),
                    created_at = table.Column<DateTime>(type: "TEXT", nullable: false),
                    updated_at = table.Column<DateTime>(type: "TEXT", nullable: true),
                    description = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    tag = table.Column<string>(type: "TEXT", maxLength: 50, nullable: false),
                    manufacturer = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    serial_number = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    model = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    size = table.Column<string>(type: "TEXT", maxLength: 20, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_pressure_gauge", x => x.uuid);
                });

            migrationBuilder.CreateTable(
                name: "roles",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    type = table.Column<int>(type: "INTEGER", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_roles", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "safety_valve",
                columns: table => new
                {
                    uuid = table.Column<string>(type: "TEXT", nullable: false),
                    actuation_gauge = table.Column<string>(type: "TEXT", maxLength: 50, nullable: false),
                    created_at = table.Column<DateTime>(type: "TEXT", nullable: false),
                    updated_at = table.Column<DateTime>(type: "TEXT", nullable: true),
                    description = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    tag = table.Column<string>(type: "TEXT", maxLength: 50, nullable: false),
                    manufacturer = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    serial_number = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    model = table.Column<string>(type: "TEXT", maxLength: 100, nullable: false),
                    size = table.Column<string>(type: "TEXT", maxLength: 20, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_safety_valve", x => x.uuid);
                });

            migrationBuilder.CreateTable(
                name: "work_orders",
                columns: table => new
                {
                    uuid = table.Column<string>(type: "TEXT", nullable: false),
                    number = table.Column<string>(type: "TEXT", maxLength: 20, nullable: false),
                    calibration_date = table.Column<DateTime>(type: "TEXT", nullable: false),
                    created_at = table.Column<DateTime>(type: "TEXT", nullable: false),
                    updated_at = table.Column<DateTime>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_work_orders", x => x.uuid);
                });

            migrationBuilder.CreateTable(
                name: "users",
                columns: table => new
                {
                    uuid = table.Column<string>(type: "TEXT", nullable: false),
                    Name = table.Column<string>(type: "TEXT", nullable: false),
                    Email = table.Column<string>(type: "TEXT", nullable: false),
                    Password = table.Column<string>(type: "TEXT", nullable: false),
                    PlanId = table.Column<int>(type: "INTEGER", nullable: false),
                    RoleId = table.Column<int>(type: "INTEGER", nullable: false),
                    created_at = table.Column<DateTime>(type: "TEXT", nullable: false),
                    updated_at = table.Column<DateTime>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_users", x => x.uuid);
                    table.ForeignKey(
                        name: "FK_users_plans_PlanId",
                        column: x => x.PlanId,
                        principalTable: "plans",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_users_roles_RoleId",
                        column: x => x.RoleId,
                        principalTable: "roles",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "customers",
                columns: table => new
                {
                    uuid = table.Column<string>(type: "TEXT", nullable: false),
                    FantasyName = table.Column<string>(type: "TEXT", nullable: false),
                    Email = table.Column<string>(type: "TEXT", nullable: false),
                    Cnpj = table.Column<string>(type: "TEXT", nullable: false),
                    CnpjFormated = table.Column<string>(type: "TEXT", nullable: false),
                    Address = table.Column<string>(type: "TEXT", nullable: false),
                    UserUuid = table.Column<string>(type: "TEXT", nullable: false),
                    created_at = table.Column<DateTime>(type: "TEXT", nullable: false),
                    updated_at = table.Column<DateTime>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_customers", x => x.uuid);
                    table.ForeignKey(
                        name: "FK_customers_users_UserUuid",
                        column: x => x.UserUuid,
                        principalTable: "users",
                        principalColumn: "uuid",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.InsertData(
                table: "plans",
                columns: new[] { "Id", "Price", "type" },
                values: new object[,]
                {
                    { 1, 0.0, 0 },
                    { 2, 29.899999999999999, 1 },
                    { 3, 49.899999999999999, 2 },
                    { 4, 69.900000000000006, 3 },
                    { 5, 149.90000000000001, 4 },
                    { 6, 199.90000000000001, 5 },
                    { 7, 299.89999999999998, 6 }
                });

            migrationBuilder.InsertData(
                table: "roles",
                columns: new[] { "Id", "type" },
                values: new object[,]
                {
                    { 1, 0 },
                    { 2, 1 },
                    { 3, 2 }
                });

            migrationBuilder.CreateIndex(
                name: "IX_customers_UserUuid",
                table: "customers",
                column: "UserUuid");

            migrationBuilder.CreateIndex(
                name: "IX_users_PlanId",
                table: "users",
                column: "PlanId");

            migrationBuilder.CreateIndex(
                name: "IX_users_RoleId",
                table: "users",
                column: "RoleId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "customers");

            migrationBuilder.DropTable(
                name: "pressure_gauge");

            migrationBuilder.DropTable(
                name: "safety_valve");

            migrationBuilder.DropTable(
                name: "work_orders");

            migrationBuilder.DropTable(
                name: "users");

            migrationBuilder.DropTable(
                name: "plans");

            migrationBuilder.DropTable(
                name: "roles");
        }
    }
}
