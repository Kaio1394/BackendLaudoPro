package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.request.CustomerCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.CustomerCreateResponse;
import com.kaiosantiago.laudopro.entity.Customer;
import com.kaiosantiago.laudopro.exceptions.CnpjAndCnpjFormatedNotMatchException;
import com.kaiosantiago.laudopro.exceptions.CustomerAlreadyExistsException;
import com.kaiosantiago.laudopro.mapper.CustomerMapper;
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
    public CompletableFuture<List<CustomerCreateResponse>> getAllCustomersAsync(){
        return CompletableFuture.supplyAsync(() -> {
            var listCustomerDto = this.customerRepository.findAll()
                    .stream().map(customer -> {
                        return CustomerMapper.customertToCustomerCreateResponse(customer);
                    }).toList();
            return listCustomerDto;
        });
    }

    @Async
    public CompletableFuture<CustomerCreateResponse> getCustomerByFantasyName(String fantasyName){
        return CompletableFuture.supplyAsync(() -> {
            var query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.fantasyName = :fantasyName", Customer.class);
            query.setParameter("fantasyName", fantasyName);

            var result = query.getResultStream().findFirst().orElse(null);
            return result != null? CustomerMapper.customertToCustomerCreateResponse(result): null;
        });
    }

    @Async
    public CompletableFuture<CustomerCreateResponse> createAsync(CustomerCreateRequest dtoCreate) {
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

                Customer customer = CustomerMapper.customerCreateRequestToCustomer(dtoCreate);
                Customer saved = customerRepository.save(customer);

                return CustomerMapper.customertToCustomerCreateResponse(saved);

            } catch (Exception e) {
                throw e;
            }
        });
    }

}
