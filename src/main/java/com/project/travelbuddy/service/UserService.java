package com.project.travelbuddy.service;

import com.project.travelbuddy.model.User;
import com.project.travelbuddy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getOrCreateUser(String externalId, String username, String email, String avatarUrl) {
        return userRepository.findByExternalId(externalId)
                .orElseGet(() -> {
                    User user = new User(externalId, username, email, avatarUrl);
                    return userRepository.save(user);
                });
    }
}
