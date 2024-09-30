package com.example.springbooot_proj.service;


import com.example.springbooot_proj.models.Role;
import com.example.springbooot_proj.models.User;
import com.example.springbooot_proj.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private List<User> userList = new ArrayList<>();

    private final UserRepository userRepository;

    //controling operations

    public List<User> getUserList(String name) {
        if(name != null) return (List<User>) userRepository.findByName(name);
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        log.info("Saving new User", user);
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(null);
    }
}
