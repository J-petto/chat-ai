package com.ll.chat_ai.domain.chat.chatRoom.service;

import com.ll.chat_ai.domain.chat.chatRoom.dto.request.RequestCreateRoom;
import com.ll.chat_ai.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom create(RequestCreateRoom createRoom) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(createRoom.getName())
                .build();

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

    public List<ChatRoom> getAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom getChatRoom(long id) {
        return chatRoomRepository.findById(id).orElseThrow();
    }
}