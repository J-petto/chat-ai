package com.ll.chat_ai.domain.chat.chatMessage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class RequestCreateChatMessage {
    private String writerName;
    private String content;
}
