package com.project.travelbuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RestController
public class TestController {

    @GetMapping("/api/hello")
    public String hello(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return "Not logged in";
        }

        String username = user.getAttribute("username");
        return "Hello " + username + "!";
    }
}
