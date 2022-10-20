package com.springboot.jwt.spring_boot_jwt_mongodb.service;

import com.springboot.jwt.spring_boot_jwt_mongodb.model.User;
import com.springboot.jwt.spring_boot_jwt_mongodb.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository repository,TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId id){
        Optional<User> result = repository.findById(id);
        return result.orElseGet(result::get);
    }


    public String saveUser(User user){
        User savedUser = repository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created User\","+
                "\"data\":"+savedUser+","+

                "\"token\":\""+tokenService.createToken(savedUser.getId())+"\"}";
    }


}
