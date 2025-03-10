package com.ll.chat_ai.chatMessage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chat_ai.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter
@Getter
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    private String writerName;
    private String content;

    @ManyToOne
    @JsonIgnore
    private ChatRoom chatRoom;
}
