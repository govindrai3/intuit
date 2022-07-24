package com.chat.chatApp.repo;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chat.chatApp.model.ChatMessage;
import com.chat.chatApp.model.MessageStatus;

public interface ChatMessageRepository
        extends MongoRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}