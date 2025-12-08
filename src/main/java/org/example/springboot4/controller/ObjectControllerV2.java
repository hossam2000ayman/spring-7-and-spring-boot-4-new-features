package org.example.springboot4.controller;

import org.example.springboot4.service.ObjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/{version}/objects", version = "2")
public class ObjectControllerV2 {
    private final ObjectService objectService;

    public ObjectControllerV2(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping
    public List<Object> getObjects(@PathVariable String version) {
        return objectService.getObjects();
    }
}
