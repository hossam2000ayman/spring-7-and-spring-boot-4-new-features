package org.example.springboot4.service.auth;

public class GoogleAuthenticationProvider implements AuthenticationProvider {
    @Override
    public String login() {
        return "Sign in using Google Account";
    }
}
