package com.example.springbooot_proj.controlle;


import com.example.springbooot_proj.models.User;
import com.example.springbooot_proj.service.UserService;
import com.example.springbooot_proj.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserServiceImpl userServiceImpl;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        userServiceImpl.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityURL() {
        return "hello";
    }

}
