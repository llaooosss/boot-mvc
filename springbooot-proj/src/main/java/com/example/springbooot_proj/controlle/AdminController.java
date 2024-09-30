package com.example.springbooot_proj.controlle;

import com.example.springbooot_proj.models.User;
import com.example.springbooot_proj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @RequestMapping("/home")
    public String allUsers(@RequestParam(name = "name", required = true) String name, Model model) {
       model.addAttribute("home", userService.getUserList(name));
       return "home";
    }

    @PostMapping("/users/create")
    public String saveUsers(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/users/{id}")
    public String userInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }
}
