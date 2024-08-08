package com.example.Tinder.AI.backed;

import com.example.Tinder.AI.backed.Conversations.ChatMessage;
import com.example.Tinder.AI.backed.Conversations.Conversation;
import com.example.Tinder.AI.backed.Conversations.ConversationRepository;
import com.example.Tinder.AI.backed.Profiles.Gender;
import com.example.Tinder.AI.backed.Profiles.Profile;
import com.example.Tinder.AI.backed.Profiles.ProfileCreationService;
import com.example.Tinder.AI.backed.Profiles.ProfileRepository;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackedApplication implements CommandLineRunner {


	@Autowired
	private ProfileCreationService profileCreationService;



	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackedApplication.class, args);
	}

	public void  run(String... args){

		profileCreationService.saveProfilesToDB();
	}




}
