package com.example.twitter.services;

import com.example.twitter.models.Comment;
import com.example.twitter.models.Tweet;
import com.example.twitter.repositories.CommentRepository;
import com.example.twitter.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsWithTweet(Long tweetID){
        Tweet tweet = tweetRepository.findById(tweetID).get();
        return commentRepository.findByTweet(tweet);
    }
}
