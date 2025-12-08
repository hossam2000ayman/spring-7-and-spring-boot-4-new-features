package org.example.springboot4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(basePackages = "org.example.springboot4")
public class SpringBoot4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot4Application.class, args);
    }

}
