package com.tweetero.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweetero.api.dtos.TweetDTO;
import com.tweetero.api.models.TweetModel;
import com.tweetero.api.models.UserModel;
import com.tweetero.api.repositories.TweetRepository;
import com.tweetero.api.repositories.UserRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;
    final UserRepository userRepository;

    TweetService( TweetRepository tweetRepository, UserRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }

    public Optional<TweetModel> save(TweetDTO dto) {
        Optional<UserModel> user = userRepository.findById(dto.getUserId());
        if (!user.isPresent()) {
            return Optional.empty();
        }
        TweetModel tweet = new TweetModel(dto, user.get());
        return Optional.of(tweetRepository.save(tweet));
    }

    public Optional<Object> findByUser(Long userId){
        return Optional.of(tweetRepository.findByUserId(userId));
    }

    
    
}
