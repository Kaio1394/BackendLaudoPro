
using LaudoPro.Domain.Enums;
using LaudoPro.Domain.Models;
using LaudoPro.Domain.Models.Base;
using Microsoft.EntityFrameworkCore;

namespace LaudoPro.Infrastructure.Data
{
    public class LaudoProDbContext: DbContext
    {
        public DbSet<Plan> Plans { get; set; }
        public DbSet<Role> Roles { get; set; }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<SafetyValve> SafetyValves { get; set; }
        public DbSet<WorkOrder> WorkOrders { get; set; }
        public DbSet<PressureGauge> PressureGauges { get; set; }
        public LaudoProDbContext(DbContextOptions<LaudoProDbContext> options): base(options) { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            //modelBuilder.Entity<BaseInstrument>()
            //            .HasIndex(b => b.Tag)
            //            .IsUnique();

            modelBuilder.Entity<Plan>().HasData(
                new Plan { Id = 1, Type = PlanType.FREE, Price = 0.0 },
                new Plan { Id = 2, Type = PlanType.INDIVIDUAL_BASIC, Price = 29.90 },
                new Plan { Id = 3, Type = PlanType.INDIVIDUAL_STANDARD, Price = 49.90 },
                new Plan { Id = 4, Type = PlanType.INDIVIDUAL_PREMIUM, Price = 69.90 },
                new Plan { Id = 5, Type = PlanType.COMPANY_BASIC, Price = 149.90 },
                new Plan { Id = 6, Type = PlanType.COMPANY_STANDARD, Price = 199.90 },
                new Plan { Id = 7, Type = PlanType.COMPANY_PREMIUM, Price = 299.90 }
            );
            modelBuilder.Entity<Role>().HasData(
                new Role { Id = 1, Type = RoleType.ADMIN },
                new Role { Id = 2, Type = RoleType.TECHNICIAN },
                new Role { Id = 3, Type = RoleType.APPROVER }
            );
        }
    }
}
