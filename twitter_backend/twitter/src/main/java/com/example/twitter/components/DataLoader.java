package com.example.twitter.components;

import com.example.twitter.models.Tweet;
import com.example.twitter.models.User;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    public void run(ApplicationArguments args) throws Exception {

//        List<User> users = Arrays.asList(
//                new User("Steve","@gmail","12345")
//        );
//        userRepository.saveAll(users);
        User user = new User("Steve","@gmail","12345");
        userRepository.save(user);

        Tweet tweet = new Tweet(LocalDateTime.now(),"First Tweet",user);
        tweetRepository.save(tweet);
    }
}
