package com.example.Tinder.AI.backed.Conversations;

import java.time.LocalDateTime;

public record ChatMessage(
        String messageText,
        String authorId,

        LocalDateTime messageTime
) {
}
