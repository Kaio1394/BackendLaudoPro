using AutoMapper;
using LaudoPro.Application.DTOs.SafetyValve;
using LaudoPro.Application.Mapper;
using LaudoPro.Application.Services;
using LaudoPro.Domain.Interfaces.Repositories;
using LaudoPro.Domain.Models;
using Moq;

namespace LaudoProUnitTest.Tests
{
    [TestFixture]
    public class SafetyValveServiceTest
    {
        private IMapper _mapper;

        [OneTimeSetUp]
        public void OneTimeSetUp()
        {
            var config = new MapperConfiguration(cfg => cfg.AddProfile<MappingProfile>());
            _mapper = config.CreateMapper();
        }

        [Test]
        public async Task GetAllAsync_ReturnsMappedDtos()
        {
            var items = new List<SafetyValve>
            {
                new SafetyValve { Uuid = Guid.NewGuid().ToString(), ActuationGauge = "0,5 kgf/cm²", Description = "SV1", Tag = "TAG-1" },
                new SafetyValve { Uuid = Guid.NewGuid().ToString(), ActuationGauge = "1,0 kgf/cm²", Description = "SV2", Tag = "TAG-2" }
            };

            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.GetAllAsync()).ReturnsAsync(items);

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            var result = (await service.GetAllAsync()).ToList();

            Assert.IsNotNull(result);
            Assert.AreEqual(items.Count, result.Count);
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }

        [Test]
        public async Task GetByUuidAsync_ReturnsMappedDto_WhenExists()
        {
            var uuid = Guid.NewGuid().ToString();
            var entity = new SafetyValve { Uuid = uuid, ActuationGauge = "0,5 kgf/cm²", Description = "SV1", Tag = "TAG-1" };

            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.GetByUuidAsync(uuid)).ReturnsAsync(entity);

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            var dto = await service.GetByUuidAsync(uuid);

            Assert.IsNotNull(dto);
            mockRepo.Verify(r => r.GetByUuidAsync(uuid), Times.Once);
        }

        [Test]
        public async Task AddAsync_InvokesRepositoryAndReturnsDto()
        {
            var request = new SafetyValveRequestDto(); // DTO is empty but mapping exists
            var created = new SafetyValve { Uuid = Guid.NewGuid().ToString(), ActuationGauge = "0,5 kgf/cm²", Description = "Created", Tag = "TAG-NEW" };

            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.AddAsync(It.IsAny<SafetyValve>())).ReturnsAsync(created);

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            var result = await service.AddAsync(request);

            Assert.IsNotNull(result);
            mockRepo.Verify(r => r.AddAsync(It.IsAny<SafetyValve>()), Times.Once);
        }

        [Test]
        public async Task DeleteAsync_ReturnsFalse_WhenNotFound()
        {
            var dto = new SafetyValveDeleteDto { Uuid = Guid.NewGuid().ToString() };

            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.GetByUuidAsync(dto.Uuid)).ReturnsAsync((SafetyValve?)null);

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            var result = await service.DeleteAsync(dto);

            Assert.IsFalse(result);
            mockRepo.Verify(r => r.GetByUuidAsync(dto.Uuid), Times.Once);
            mockRepo.Verify(r => r.DeleteAsync(It.IsAny<SafetyValve>()), Times.Never);
        }

        [Test]
        public async Task DeleteAsync_ReturnsTrue_WhenDeleted()
        {
            var dto = new SafetyValveDeleteDto { Uuid = Guid.NewGuid().ToString() };
            var entity = new SafetyValve { Uuid = dto.Uuid, ActuationGauge = "0,5 kgf/cm²", Tag = "TAG-DEL" };

            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.GetByUuidAsync(dto.Uuid)).ReturnsAsync(entity);
            mockRepo.Setup(r => r.DeleteAsync(entity)).ReturnsAsync(true);

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            var result = await service.DeleteAsync(dto);

            Assert.IsTrue(result);
            mockRepo.Verify(r => r.GetByUuidAsync(dto.Uuid), Times.Once);
            mockRepo.Verify(r => r.DeleteAsync(entity), Times.Once);
        }

        [Test]
        public void GetAllAsync_RepositoryThrows_ExceptionPropagates()
        {
            var mockRepo = new Mock<IRepository<SafetyValve>>();
            mockRepo.Setup(r => r.GetAllAsync()).ThrowsAsync(new InvalidOperationException("repo failure"));

            var service = new SafetyValveService(mockRepo.Object, _mapper);

            Assert.ThrowsAsync<InvalidOperationException>(async () => await service.GetAllAsync());
            mockRepo.Verify(r => r.GetAllAsync(), Times.Once);
        }
    }
}
