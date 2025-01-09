package com.ll.chat_ai.domain.chat.chatMessage.controller;

import com.ll.chat_ai.domain.chat.chatMessage.dto.request.RequestCreateChatMessage;
import com.ll.chat_ai.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.domain.chat.chatMessage.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms")
@RestController
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatMessageController {

    private final ChatMessageService chatMessageService;

    @GetMapping("{roomId}/messages")
    public List<ChatMessage> chatMessages(@PathVariable long roomId,
                                          @RequestParam(value = "afterChatMessageId", required = false) long afterChatMessageId) {



        return chatMessageService.getMessages(roomId, afterChatMessageId);
    }

    @PostMapping("{roomId}/messages")
    public String createChatMessage(@PathVariable long roomId, @RequestBody RequestCreateChatMessage requestCreateChatMessage) {

        chatMessageService.make(roomId, requestCreateChatMessage.getWriterName(), requestCreateChatMessage.getContent());

        return "채팅방 메시지 생성 완료";
    }
}
