package com.example.Tinder.AI.backed.Matches;

import com.example.Tinder.AI.backed.Profiles.Profile;

public record Match(
        String Id,
        Profile profile,
        String conversationId
) {
}
