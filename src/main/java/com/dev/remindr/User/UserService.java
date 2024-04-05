package com.dev.remindr.User;

import com.dev.remindr.common.Helpers;
import com.dev.remindr.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        try {
            if (user.getEmail().isEmpty()) {
                throw new ApiRequestException("Email cannot be empty");
            }
            if (userRepository.existsByEmail(user.getEmail())) {
                throw new ApiRequestException("User with email " + user.getEmail() + " already exists");
            }
            user.setId(Helpers.generateHash(user.getEmail()));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ApiRequestException(e.getMessage());
        }
    }
}
