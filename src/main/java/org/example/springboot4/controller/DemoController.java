package org.example.springboot4.controller;

import org.example.springboot4.service.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(@Qualifier("myCustomService") DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping("/demo-name")
    public String demoName() {
        return demoService.demoName();
    }
}
