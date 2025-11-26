package com.project.travelbuddy.service;

import com.project.travelbuddy.repository.MessageRepository;
import com.project.travelbuddy.repository.ThreadRepository;
import com.project.travelbuddy.model.Message;
import com.project.travelbuddy.model.ChatThread;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private MessageRepository messageRepository;

    // Get all chat threads
    public List<ChatThread> getThreads() {
        return threadRepository.findAll();
    }

    // Get messages for a thread
    public List<Message> getMessages(Long threadId) {
        return messageRepository.findByThread_Id(threadId);
    }

    // Add message to a thread
    public Message addMessage(Long threadId, String username, String text) {
        ChatThread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread not found"));

        Message message = new Message();
        message.setThread(thread);
        message.setUsername(username);
        message.setText(text);

        return messageRepository.save(message);
    }
}
