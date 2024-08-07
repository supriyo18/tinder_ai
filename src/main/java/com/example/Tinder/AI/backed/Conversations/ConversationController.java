package com.example.Tinder.AI.backed.Conversations;

import com.example.Tinder.AI.backed.Profiles.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@RestController
public class ConversationController {


    private final ConversationRepository conversationRepository;

    private final ProfileRepository profileRepository;

    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }


    @PostMapping("/conversations")
    public Conversation createNewConversation(@RequestBody  ConversationRequest request){

        //check valid profile by ID

        profileRepository.findById(request.profileId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"unable to find profile id"));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId(),
                new ArrayList<>()
        );

        conversationRepository.save(conversation);

        return  conversation;
    }

    @PutMapping("/conversations/{conversationId}")
    public Conversation addMessageToConversation(@PathVariable String conversationId ,  @RequestBody ChatMessage chatMessage){

       Conversation conversation =  conversationRepository.findById(conversationId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find conversation Id"));

        profileRepository.findById(chatMessage.authorId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"unable to find author id"));

        // need to validate author of message happens to be only the profile matched with AI id
       ChatMessage chatMessageWithTime = new ChatMessage(
               chatMessage.messageText(),
               chatMessage.authorId(),
               LocalDateTime.now()
       );
        conversation.messages().add(chatMessageWithTime);

        conversationRepository.save(conversation);
        return conversation;
    }

    @GetMapping("/conversations/{conversationId}")
     public Conversation getConversation(@PathVariable String conversationId){
        Conversation conversation =  conversationRepository.findById(conversationId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find conversation Id"));

        return conversation;
    }
}
