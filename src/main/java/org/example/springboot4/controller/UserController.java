package org.example.springboot4.controller;

import org.example.springboot4.service.auth.AuthenticationProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final AuthenticationProvider authenticationProvider;

    public UserController(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @GetMapping("names")
    public List<String> getUsers() {
        return Arrays.asList("ahmed", "mohamed", "khaled");
    }


    @PostMapping("/login")
    public String login() {
        return authenticationProvider.login();
    }

}
