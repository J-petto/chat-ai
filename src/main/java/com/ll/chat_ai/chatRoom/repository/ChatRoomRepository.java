package com.ll.chat_ai.chatRoom.repository;

import com.ll.chat_ai.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
