package com.project.travelbuddy.controller;

import com.project.travelbuddy.model.User;
import com.project.travelbuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Insert a user via POST request
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user.getExternalId(), user.getUsername(), user.getEmail());
    }
}
