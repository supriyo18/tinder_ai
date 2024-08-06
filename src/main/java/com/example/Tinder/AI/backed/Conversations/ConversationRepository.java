package com.example.Tinder.AI.backed.Conversations;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation,String> {
}
