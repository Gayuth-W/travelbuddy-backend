package com.project.travelbuddy.model;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String text;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private ChatThread thread;

    @ManyToOne
    @JoinColumn(name = "user_id")  // link to User table
    private User user;

    // Constructors
    public Message() {}

    public Message(Long id, String username, String text, ChatThread thread, User user) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.thread = thread;
        this.user = user;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public ChatThread getThread() { return thread; }
    public void setThread(ChatThread thread) { this.thread = thread; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
