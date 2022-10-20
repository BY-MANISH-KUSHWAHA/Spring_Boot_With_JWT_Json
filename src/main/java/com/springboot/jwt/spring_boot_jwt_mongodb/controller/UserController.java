package com.springboot.jwt.spring_boot_jwt_mongodb.controller;


import com.springboot.jwt.spring_boot_jwt_mongodb.model.User;
import com.springboot.jwt.spring_boot_jwt_mongodb.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public User GatUser(HttpServletRequest req){
        ObjectId userId =  (ObjectId) req.getAttribute("userId");
        return userService.getUser(userId);
    }

}
