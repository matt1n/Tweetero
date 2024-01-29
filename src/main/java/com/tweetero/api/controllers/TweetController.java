package com.tweetero.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dtos.TweetDTO;
import com.tweetero.api.models.TweetModel;
import com.tweetero.api.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    TweetController( TweetService tweetService ){
        this.tweetService = tweetService;
    }

    @GetMapping
    public ResponseEntity<Object> getTweets(){
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.findAll());
    } 

    @PostMapping
    public ResponseEntity<Object> postTweet(@RequestBody @Valid TweetDTO body) {
        Optional<TweetModel> tweet = tweetService.save(body);
        if (tweet.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet.get());
    }
    
    
}
