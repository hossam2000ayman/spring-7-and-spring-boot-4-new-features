package org.example.springboot4.controller;

import org.example.springboot4.service.auth.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/{version}/users", version = "1")
public class UserControllerV1 {

    private final AuthenticationProvider authenticationProvider;

    public UserControllerV1(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @GetMapping("names")
    public List<String> getUsers(@PathVariable String version) {
        return Arrays.asList("mazen", "amr", "abdelgawad");
    }


    @PostMapping("/login")
    public String login(@PathVariable String version) {
        return authenticationProvider.login();
    }

    @GetMapping(value = "/login", version = "1.2+")
    public String loginV2(@PathVariable String version) {
        return authenticationProvider.login() + "__ v2";
    }

}
