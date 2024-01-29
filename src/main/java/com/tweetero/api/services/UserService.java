package com.tweetero.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweetero.api.dtos.UserDTO;
import com.tweetero.api.models.UserModel;
import com.tweetero.api.repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } 

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserModel> save(UserDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())){
            return Optional.empty();
        }
        UserModel user = new UserModel(dto);
        return Optional.of(userRepository.save(user));
    }
}
