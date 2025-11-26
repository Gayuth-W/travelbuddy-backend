package com.project.travelbuddy.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ChatThread {

    public ChatThread() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<Message> messages;

    // Getters and setters
}
