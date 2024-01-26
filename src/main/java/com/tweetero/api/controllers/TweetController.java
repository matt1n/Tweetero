package com.tweetero.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.models.TweetModel;
import com.tweetero.api.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    TweetController( TweetService tweetService ){
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<TweetModel> getTweets(){
        return tweetService.findAll();
    } 
    
}
