package com.ll.chat_ai.global.initData;

import com.ll.chat_ai.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.chatMessage.repository.ChatMessageRepository;
import com.ll.chat_ai.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.chatRoom.dto.request.RequestCreateRoom;
import com.ll.chat_ai.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    @Transactional
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService) {
        return args -> {
            ChatRoom chatRoom1 = chatRoomService.create(new RequestCreateRoom("공부"));
            ChatRoom chatRoom2 = chatRoomService.create(new RequestCreateRoom("식사"));
            ChatRoom chatRoom3 = chatRoomService.create(new RequestCreateRoom("휴식"));

            IntStream.rangeClosed(1, 30).forEach(num -> {
                chatMessageService.make(1, "황민지", "공부 메시지" + num);
            });
        };
    }
}
