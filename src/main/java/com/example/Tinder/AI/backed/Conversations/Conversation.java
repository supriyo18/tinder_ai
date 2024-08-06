package com.example.Tinder.AI.backed.Conversations;

import com.example.Tinder.AI.backed.Profiles.Profile;

import java.util.List;

public record Conversation(
        String id,
        String profileId,
        List<ChatMessage> messages
) {
}
