using LaudoPro.Application.Services;
using LaudoPro.Domain.Enums;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaudoProUnitTest.Tests
{
    [TestFixture]
    public class RoleServiceTest
    {
        [Test]
        public async Task GetAllAsync_ReturnsAllRoles()
        {
            var roles = new List<Role>
            {
                new Role { Id = 1, Type = RoleType.ADMIN },
                new Role { Id = 2, Type = RoleType.TECHNICIAN }
            };

            var mockRepo = new Mock<IRoleRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ReturnsAsync(roles);

            var service = new RoleService(mockRepo.Object);

            var result = (await service.GetAllAsync()).ToList();

            Assert.IsNotNull(result);
            Assert.AreEqual(2, result.Count);

            Assert.AreEqual(roles[0].Id, result[0].Id);
            Assert.AreEqual(roles[0].Type.ToString(), result[0].Type);

            Assert.AreEqual(roles[1].Id, result[1].Id);
            Assert.AreEqual(roles[1].Type.ToString(), result[1].Type);

            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }

        [Test]
        public async Task GetAllAsync_EmptyList_ReturnsEmpty()
        {
            var mockRepo = new Mock<IRoleRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ReturnsAsync(new List<Role>());

            var service = new RoleService(mockRepo.Object);

            var result = await service.GetAllAsync();

            Assert.IsNotNull(result);
            Assert.IsEmpty(result);
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }

        [Test]
        public void GetAllAsync_RepositoryThrows_ExceptionPropagates()
        {
            var mockRepo = new Mock<IRoleRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ThrowsAsync(new InvalidOperationException("repository failure"));

            var service = new RoleService(mockRepo.Object);

            Assert.ThrowsAsync<InvalidOperationException>(async () => await service.GetAllAsync());
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }
    }
}
