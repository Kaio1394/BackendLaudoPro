
using LaudoPro.Application.Services;
using LaudoPro.Domain.Enums;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using Moq;

namespace LaudoProUnitTest.Tests
{
    [TestFixture]
    public class PlanServiceTest
    {
        [Test]
        public async Task GetAllAsync_ReturnsAllPlans()
        {
            var plans = new List<Plan>
            {
                new Plan { Id = 1, Type = PlanType.FREE, Price = 0.0 },
                new Plan { Id = 2, Type = PlanType.INDIVIDUAL_BASIC, Price = 29.90 }
            };

            var mockRepo = new Mock<IPlanRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ReturnsAsync(plans);

            var service = new PlanService(mockRepo.Object);

            var result = await service.GetAllAsync();

            Assert.IsNotNull(result);
            Assert.AreEqual(plans.Count, result.Count());
            CollectionAssert.AreEqual(plans, result.ToList());
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }

        [Test]
        public async Task GetAllAsync_EmptyList_ReturnsEmpty()
        {
            var mockRepo = new Mock<IPlanRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ReturnsAsync(new List<Plan>());

            var service = new PlanService(mockRepo.Object);

            var result = await service.GetAllAsync();

            Assert.IsNotNull(result);
            Assert.IsEmpty(result);
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }

        [Test]
        public void GetAllAsync_RepositoryThrows_ExceptionPropagates()
        {
            var mockRepo = new Mock<IPlanRepository>();
            mockRepo.Setup(r => r.GetAllAsync()).ThrowsAsync(new InvalidOperationException("repository failure"));

            var service = new PlanService(mockRepo.Object);

            Assert.ThrowsAsync<InvalidOperationException>(async () => await service.GetAllAsync());
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }
    }
}