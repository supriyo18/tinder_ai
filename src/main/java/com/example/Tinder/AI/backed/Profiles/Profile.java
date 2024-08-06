package com.example.Tinder.AI.backed.Profiles;

public record Profile(
        String id,
        String firstName,
        String lastName,
        String bio,
        Integer age,
        String imageUrl,
        String ethnicity,
        Gender gender,
        String myersBriggsPersonalityType
) {
}
