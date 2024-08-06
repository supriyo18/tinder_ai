package com.example.Tinder.AI.backed;

import com.example.Tinder.AI.backed.Conversations.ChatMessage;
import com.example.Tinder.AI.backed.Conversations.Conversation;
import com.example.Tinder.AI.backed.Conversations.ConversationRepository;
import com.example.Tinder.AI.backed.Profiles.Gender;
import com.example.Tinder.AI.backed.Profiles.Profile;
import com.example.Tinder.AI.backed.Profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackedApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConversationRepository conversationRepository;
	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackedApplication.class, args);
	}

	public void  run(String... args){
		Profile profile = new Profile(
				"1",
				"Supriyo",
				"Mukherjee",
				"I am artist",
				34,
				"foo.jpeg",
				"Indian",
				Gender.MALE,
				"INTP"
		);

		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);

		Conversation conversation = new Conversation(
				"1",
				profile.id(),
				List.of(new ChatMessage("Hi I am new",profile.id(), LocalDateTime.now()))
		);

		conversationRepository.save(conversation);
		conversationRepository.findAll().forEach(System.out::println);

	}




}
