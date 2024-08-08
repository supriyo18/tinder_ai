package com.example.Tinder.AI.backed.Matches;


import com.example.Tinder.AI.backed.Conversations.Conversation;
import com.example.Tinder.AI.backed.Conversations.ConversationRepository;
import com.example.Tinder.AI.backed.Profiles.Profile;
import com.example.Tinder.AI.backed.Profiles.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MatchController {


    private final ProfileRepository profileRepository;

    private final ConversationRepository conversationRepository;


    private  final  MatchRepository matchRepository;

    public MatchController (ProfileRepository profileRepository, ConversationRepository conversationRepository, MatchRepository matchRepository) {
        this.profileRepository = profileRepository;
        this.conversationRepository = conversationRepository;
        this.matchRepository = matchRepository;
    }

    @PostMapping("/matches")
    public Match createMatch(@RequestBody CreateMatchRequest request){

        //check valid profile by ID

      Profile profile =  profileRepository.findById(request.profileId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"unable to find profile id"));

      // TODO : Make sure no existing conversation with this profile
        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                profile.id(),
                new ArrayList<>()
        );

        conversationRepository.save(conversation);
       Match match = new Match(UUID.randomUUID().toString(),profile,conversation.id());


       matchRepository.save(match);
        return match;
    }


    @GetMapping("/matches")
    public List<Match> getAllMatch(){
         return  matchRepository.findAll();
    }
}
