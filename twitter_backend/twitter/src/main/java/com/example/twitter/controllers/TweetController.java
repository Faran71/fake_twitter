package com.example.twitter.controllers;

import com.example.twitter.models.Tweet;
import com.example.twitter.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tweets"})
public class TweetController {

    @Autowired
    TweetService tweetService;

    @GetMapping
    public ResponseEntity<List<Tweet>> getAllTweets(){
        return new ResponseEntity(tweetService.findAllTweets(), HttpStatus.FOUND);
    }

    @PostMapping(value = "postTweet/{userId}")
    public ResponseEntity<Tweet> postTweet(@PathVariable Long userId, @RequestBody String Content){
        Tweet createTweet = tweetService.createTweet(userId, Content);
        return new ResponseEntity(createTweet, HttpStatus.CREATED);
    }
}
