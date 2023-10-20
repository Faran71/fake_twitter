package com.example.twitter.services;

import com.example.twitter.models.Tweet;
import com.example.twitter.models.User;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    public List<Tweet> findAllTweets(){
        return tweetRepository.findAll();
    }

    public Tweet createTweet(Long userId, String Content){
        Tweet newTweet = new Tweet();
        User user = userRepository.findById(userId).get();
        newTweet.setUser(user);
        newTweet.setTweetDateTime(LocalDateTime.now());
        newTweet.setContent(Content);
        tweetRepository.save(newTweet);
        return newTweet;
    }


}
