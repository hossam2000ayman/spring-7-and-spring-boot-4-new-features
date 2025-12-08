package org.example.springboot4.client;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

import java.util.List;
import java.util.Set;

@HttpExchange("https://api.restful-api.dev/objects")
public interface ObjectClient {
    @GetExchange
    List<Object> getObjects();

    @GetExchange
    List<Object> getObjectsByIds(@RequestParam Set<String> ids);

    @GetExchange("/{id}")
    Object getObjectById(@PathVariable Integer id);

    @PostExchange
    Object addObject(@RequestBody Object object);

    @PutExchange("/{id}")
    Object updateObject(@PathVariable Integer id, @RequestBody Object object);

    @PatchExchange("/{id}")
    Object partialUpdateObject(@PathVariable Integer id, @RequestBody Object object);

    @DeleteExchange("/{id}")
    Object deleteObject(@PathVariable Integer id);

}
