package com.example.Tinder.AI.backed.Profiles;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile,String> {

    //Aggregatation query
    // {$sample : {size : 1}}

    @Aggregation(pipeline = {"{ $sample : {size : 1 }}"})
    Profile getRandomProfile ();
}
