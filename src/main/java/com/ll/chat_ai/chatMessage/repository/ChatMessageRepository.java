package com.ll.chat_ai.chatMessage.repository;

import com.ll.chat_ai.chatMessage.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
