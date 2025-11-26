package com.project.travelbuddy.DTO;

public class MessageRequest {
    private String text;


    public MessageRequest(String message) {
        this.text = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public MessageRequest() {
    }
}
