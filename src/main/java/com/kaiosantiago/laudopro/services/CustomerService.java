package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.CustomerDto;
import com.kaiosantiago.laudopro.dtos.CustomerReadDto;
import com.kaiosantiago.laudopro.entity.Customer;
import com.kaiosantiago.laudopro.exceptions.CnpjAndCnpjFormatedNotMatchException;
import com.kaiosantiago.laudopro.exceptions.CustomerAlreadyExistsException;
import com.kaiosantiago.laudopro.mapper.customer.CustomerDtoCreateMapper;
import com.kaiosantiago.laudopro.mapper.customer.CustomerMapper;
import com.kaiosantiago.laudopro.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {
    @PersistenceContext
    private EntityManager entityManager;

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Async
    public CompletableFuture<List<CustomerReadDto>> getAllCustomersAsync(){
        var listCustomerDto = this.customerRepository.findAll()
                .stream().map(customer -> {
                    CustomerReadDto dto = new CustomerReadDto();
                    dto.setFantasyName(customer.getFantasyName());
                    dto.setCnpj(customer.getCnpj());
                    dto.setCnpjFormated(customer.getCnpjFormated());
                    dto.setAddress(customer.getAddress());
                    dto.setEmail(customer.getEmail());
                    dto.setCreatedAt(customer.getCreatedAt());
                    dto.setUpdatedAt(customer.getUpdatedAt());
                    return dto;
                }).toList();
        return CompletableFuture.completedFuture(listCustomerDto);
    }

    @Async
    public CompletableFuture<CustomerDto> getCustomerByFantasyName(String fantasyName){
        return CompletableFuture.supplyAsync(() -> {
            var query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.fantasyName = :fantasyName", Customer.class);
            query.setParameter("fantasyName", fantasyName);

            var result = query.getResultStream().findFirst().orElse(null);
            return result != null? CustomerMapper.toCustomerDto(result): null;
        });
    }

    @Async
    public CompletableFuture<CustomerDto> createAsync(CustomerCreateDto dtoCreate) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String fantasyName = dtoCreate.getFantasyName();
                String cnpj = dtoCreate.getCnpj();
                String cnpjFormated = dtoCreate.getCnpjFormated();
                cnpjFormated = cnpjFormated.replace(".", "").replace("/", "").replace("-", "");

                if(!Objects.equals(cnpj, cnpjFormated)) throw new CnpjAndCnpjFormatedNotMatchException("CNPJ and formatted CNPJ do not match");

                var existing = customerRepository.findByFantasyName(fantasyName);
                if (existing.isPresent()) {
                    throw new CustomerAlreadyExistsException("Customer already exists with fantasy name [" + fantasyName + "].");
                }
                existing = customerRepository.findByCnpj(cnpj);
                if (existing.isPresent()) {
                    throw new CustomerAlreadyExistsException("Customer already exists with CNPJ [" + cnpj + "].");
                }

                Customer customer = CustomerDtoCreateMapper.toCustomer(dtoCreate);
                Customer saved = customerRepository.save(customer);

                return CustomerMapper.toCustomerDto(saved);

            } catch (Exception e) {
                throw e;
            }
        });
    }

}
