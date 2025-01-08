package com.ll.chat_ai.chatRoom.controller;

import com.ll.chat_ai.chatMessage.entity.ChatMessage;
import com.ll.chat_ai.chatMessage.service.ChatMessageService;
import com.ll.chat_ai.chatRoom.dto.request.RequestCreateRoom;
import com.ll.chat_ai.chatRoom.entity.ChatRoom;
import com.ll.chat_ai.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;

    @GetMapping
    public List<ChatRoom> getChatRooms() {
        List<ChatRoom> ChatRooms = chatRoomService.getAll();
        return ChatRooms;
    }

    @GetMapping("{roomId}")
    public ChatRoom getChatRoom(@PathVariable("roomId") long roomId) {
        return chatRoomService.getChatRoom(roomId);
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody RequestCreateRoom requestCreateRoom) {
        return chatRoomService.create(requestCreateRoom);
    }

}