package com.project.travelbuddy.service;

import com.project.travelbuddy.model.User;
import com.project.travelbuddy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Add a new user
    public User addUser(String externalId, String username, String email) {
        User user = new User(externalId, username, email);
        return userRepository.save(user);
    }

    // Optional: find by externalId
    public User getUserByExternalId(String externalId) {
        return userRepository.findByExternalId(externalId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
