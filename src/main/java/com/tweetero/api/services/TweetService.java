package com.tweetero.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tweetero.api.models.TweetModel;
import com.tweetero.api.repositories.TweetRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;

    TweetService( TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }
}
