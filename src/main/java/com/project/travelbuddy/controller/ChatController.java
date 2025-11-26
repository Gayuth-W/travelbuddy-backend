package com.project.travelbuddy.controller;

import com.project.travelbuddy.DTO.MessageRequest;
import com.project.travelbuddy.model.Message;
import com.project.travelbuddy.model.ChatThread;
import com.project.travelbuddy.model.User;
import com.project.travelbuddy.service.ChatService;
import com.project.travelbuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;

    @GetMapping("/threads")
    public List<ChatThread> getThreads() {
        return chatService.getThreads();
    }

    @GetMapping("/threads/{threadId}/messages")
    public List<Message> getMessages(@PathVariable Long threadId) {
        return chatService.getMessages(threadId);
    }

//    @PostMapping("/threads/{threadId}/messages")
//    public void postMessage(@PathVariable Long threadId,
//                            @RequestBody String text,
//                            @AuthenticationPrincipal OidcUser oidcUser) {
//        if (oidcUser == null) {
//            throw new RuntimeException("User not authenticated");
//        }
//
//        String externalId = oidcUser.getSubject();       // unique user ID
//        String username = oidcUser.getPreferredUsername();
//        String email = oidcUser.getEmail();
//
//        // Get or create user in DB
//        User user = userService.addUser(externalId, username, email);
//
//        // Save message
//        chatService.addMessage(threadId, user.getUsername(), text);
//    }
@PostMapping("/threads/{threadId}/messages")
public void postMessage(
        @PathVariable Long threadId,
        @RequestBody MessageRequest request) {  // instead of OidcUser
    chatService.addMessage(threadId, request.getUsername(), request.getText());
}

    @GetMapping("/threads/{threadId}")
    public ChatThread getThreadById(@PathVariable Long threadId) {
        return chatService.getThreads().stream()
                .filter(thread -> thread.getId().equals(threadId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Thread not found"));
    }
}
