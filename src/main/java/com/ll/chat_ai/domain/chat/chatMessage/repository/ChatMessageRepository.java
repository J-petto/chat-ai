package com.ll.chat_ai.domain.chat.chatMessage.repository;

import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
