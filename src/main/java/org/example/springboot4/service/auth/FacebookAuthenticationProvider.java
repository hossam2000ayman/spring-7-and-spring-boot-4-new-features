package org.example.springboot4.service.auth;

public class FacebookAuthenticationProvider implements AuthenticationProvider {
    @Override
    public String login() {
        return "Sign in using Facebook Account";
    }
}
