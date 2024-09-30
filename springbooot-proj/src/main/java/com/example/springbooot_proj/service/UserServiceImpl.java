package com.example.springbooot_proj.service;

import com.example.springbooot_proj.models.Role;
import com.example.springbooot_proj.models.User;
import com.example.springbooot_proj.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public boolean createUser(User user) {
        String email = user.getEmail();
        user.getRoles().add(Role.USER);
        log.info("Saving new User with Email: {}", email);
        return true;
    }
}
