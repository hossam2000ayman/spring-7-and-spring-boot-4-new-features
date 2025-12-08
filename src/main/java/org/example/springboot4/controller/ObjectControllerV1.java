package org.example.springboot4.controller;

import org.example.springboot4.service.ObjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/{version}/objects", version = "1")
public class ObjectControllerV1 {

    private final ObjectService objectService;

    public ObjectControllerV1(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping("/all")
    public List<Object> getObjects(@PathVariable String version) {
        return objectService.getObjects();
    }

    @GetMapping("/{id}")
    public Object getObjectById(@PathVariable Integer id, @PathVariable String version) {
        return objectService.getObjectById(id);
    }

    @PostMapping
    public Object addObject(@RequestBody Object object, @PathVariable String version) {
        return objectService.addObject(object);
    }

    @PutMapping("/{id}")
    public Object updateObject(@PathVariable Integer id, @RequestBody Object object, @PathVariable String version) {
        return objectService.updateObject(id, object);
    }

    @PatchMapping("/{id}")
    public Object partialUpdateObject(@PathVariable Integer id, @RequestBody Object object, @PathVariable String version) {
        return objectService.partialUpdateObject(id, object);
    }

    @DeleteMapping("/{id}")
    public Object deleteObject(@PathVariable Integer id, @PathVariable String version) {
        return objectService.deleteObject(id);
    }

}
