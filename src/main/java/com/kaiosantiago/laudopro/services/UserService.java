package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.user.UserCreateDto;
import com.kaiosantiago.laudopro.dtos.user.UserDto;
import com.kaiosantiago.laudopro.entity.Role;
import com.kaiosantiago.laudopro.entity.User;
import com.kaiosantiago.laudopro.exceptions.PlanNotExists;
import com.kaiosantiago.laudopro.exceptions.RoleNotExists;
import com.kaiosantiago.laudopro.exceptions.UserAlreadyExists;
import com.kaiosantiago.laudopro.mapper.user.UserCreateDtoMapper;
import com.kaiosantiago.laudopro.mapper.user.UserMapper;
import com.kaiosantiago.laudopro.repositories.PlanRepository;
import com.kaiosantiago.laudopro.repositories.RoleRepository;
import com.kaiosantiago.laudopro.repositories.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    private final UserRepository repository;
    private final PlanRepository planRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository repository, PlanRepository planRepository, RoleRepository roleRepository) {
        this.repository = repository;
        this.planRepository = planRepository;
        this.roleRepository = roleRepository;
    }

    @Async
    public CompletableFuture<UserDto> addUser(UserCreateDto dtoCreate){
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
            model.setPassword(dtoCreate.getPassword());
            model.setEmail(dtoCreate.getEmail());
            model.setPlan(plan.get());
            model.setRole(role.get());

            var resultSaved = repository.save(model);

            return UserMapper.toUserDto(resultSaved);
        });
    }

    @Async
    public CompletableFuture<List<UserDto>> getAll(){
        return CompletableFuture.supplyAsync(() ->{
            var listModel = repository.findAll();
            return listModel.stream().map(UserMapper::toUserDto).toList();
        });
    }

    @Async
    public CompletableFuture<UserDto> getUserByEmail(String email){
        return CompletableFuture.supplyAsync(() -> repository.findByEmail(email)
                .map(UserMapper::toUserDto)
                .orElse(null));
    }
}
