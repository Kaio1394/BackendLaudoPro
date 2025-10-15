package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.request.UserCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.UserCreateResponse;
import com.kaiosantiago.laudopro.entity.User;
import com.kaiosantiago.laudopro.exceptions.PlanNotExists;
import com.kaiosantiago.laudopro.exceptions.RoleNotExists;
import com.kaiosantiago.laudopro.exceptions.UserAlreadyExists;
import com.kaiosantiago.laudopro.mapper.UserMapper;
import com.kaiosantiago.laudopro.repositories.PlanRepository;
import com.kaiosantiago.laudopro.repositories.RoleRepository;
import com.kaiosantiago.laudopro.repositories.UserRepository;
import com.kaiosantiago.laudopro.security.PasswordEncoderConfig;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private final UserRepository repository;
    private final PlanRepository planRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoderConfig passwordEncoderConfig;

    public UserService(UserRepository repository, PlanRepository planRepository, RoleRepository roleRepository, PasswordEncoderConfig passwordEncoderConfig) {
        this.repository = repository;
        this.planRepository = planRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    @Async
    public CompletableFuture<UserCreateResponse> addUser(UserCreateRequest dtoCreate){
        var email = dtoCreate.getEmail();
        return CompletableFuture.supplyAsync(() -> {
            var user = repository.findByEmail(email);
            if(user.isPresent())
                throw new UserAlreadyExists("User already exists with email " + email);

            var plan = planRepository.findById(dtoCreate.getPlanId());
            if(plan.isEmpty())
                throw new PlanNotExists("Plan not exists.");

            var role = roleRepository.findById(dtoCreate.getRoleId());
            if(role.isEmpty())
                throw new RoleNotExists("Role not exists.");

            var model = new User();
            model.setName(dtoCreate.getName());

            model.setEmail(dtoCreate.getEmail());
            model.setPlan(plan.get());
            model.setRole(role.get());

            String passwordEncrypt = this.passwordEncoderConfig.passwordEncoder().encode(dtoCreate.getPassword());

            model.setPassword(passwordEncrypt);

            var resultSaved = repository.save(model);

            return UserMapper.userToUserCreateResponse(resultSaved);
        });
    }

    @Async
    public CompletableFuture<List<UserCreateResponse>> getAll(){
        return CompletableFuture.supplyAsync(() ->{
            var listModel = repository.findAll();
            return listModel.stream().map(UserMapper::userToUserCreateResponse).toList();
        });
    }

    @Async
    public CompletableFuture<UserCreateResponse> getUserByEmail(String email){
        return CompletableFuture.supplyAsync(() -> repository.findByEmail(email)
                .map(UserMapper::userToUserCreateResponse)
                .orElse(null));
    }
}
