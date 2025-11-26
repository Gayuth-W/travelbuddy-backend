package com.project.travelbuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", unique = true, nullable = false)
    private String externalId; // OIDC "sub" claim, required

    @Column(nullable = false)
    private String username; // OIDC "preferred_username", required

    @Column(unique = true)
    private String email; // Optional, depending if you want to store it

    // Constructors
    public User() {}

    public User(String externalId, String username, String email) {
        this.externalId = externalId;
        this.username = username;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
