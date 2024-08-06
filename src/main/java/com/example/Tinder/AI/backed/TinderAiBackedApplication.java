package com.example.Tinder.AI.backed;

import com.example.Tinder.AI.backed.Profiles.Gender;
import com.example.Tinder.AI.backed.Profiles.Profile;
import com.example.Tinder.AI.backed.Profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TinderAiBackedApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;
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
	}

}
