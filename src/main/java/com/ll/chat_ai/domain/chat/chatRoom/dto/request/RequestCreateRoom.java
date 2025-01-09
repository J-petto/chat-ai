package com.ll.chat_ai.domain.chat.chatRoom.dto.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class RequestCreateRoom {
    private String name;
}
