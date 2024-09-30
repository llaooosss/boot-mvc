package com.example.springbooot_proj.repositories;

import com.example.springbooot_proj.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    UserDetails findByName(String name);

}
