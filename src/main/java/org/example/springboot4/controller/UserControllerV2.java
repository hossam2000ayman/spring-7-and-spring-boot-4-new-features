package org.example.springboot4.controller;

import org.example.springboot4.service.auth.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/{version}/users", version = "2")
public class UserControllerV2 {

    private final AuthenticationProvider authenticationProvider;

    public UserControllerV2(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @GetMapping("names")
    public List<String> getUsers(@PathVariable String version) {
        return Arrays.asList("ahmed", "mohamed", "khaled");
    }


    @PostMapping("/login")
    public String login(@PathVariable String version) {
        return authenticationProvider.login();
    }

}
