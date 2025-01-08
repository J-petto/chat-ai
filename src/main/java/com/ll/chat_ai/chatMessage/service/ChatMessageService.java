package com.ll.chat_ai.chatMessage.service;

import com.ll.chat_ai.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.chatMessage.repository.ChatMessageRepository;
import com.ll.chat_ai.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public void make(long id, String writerName, String content) {

        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(id);

        if(chatRoomOptional.isEmpty()){
            return;
        }

        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoomOptional.get())
                .writerName(writerName)
                .content(content)
                .build();

        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getMessages(long id, long afterMessageId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findById(id);

        return chatRoom.map(ChatRoom::getChatMessages).orElse(null);

    }
}
