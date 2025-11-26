package com.project.travelbuddy.repository;

import com.project.travelbuddy.model.ChatThread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<ChatThread, Long> {}
