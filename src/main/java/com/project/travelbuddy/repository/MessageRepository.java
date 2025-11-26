package com.project.travelbuddy.repository;

import com.project.travelbuddy.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByThread_Id(Long threadId);
}