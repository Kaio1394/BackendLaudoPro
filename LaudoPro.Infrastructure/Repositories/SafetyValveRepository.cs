using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using LaudoPro.Infrastructure.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoPro.Infrastructure.Repositories
{
    public class SafetyValveRepository : BaseRepository<SafetyValve>, ISafetyValveRepository
    {
        public SafetyValveRepository(LaudoProDbContext dbContext) : base(dbContext) { }
    }
}
