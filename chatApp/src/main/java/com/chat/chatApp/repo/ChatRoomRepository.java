package com.chat.chatApp.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chat.chatApp.model.ChatRoom;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
