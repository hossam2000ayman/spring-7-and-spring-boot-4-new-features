package org.example.springboot4.service;

import org.example.springboot4.client.ObjectClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Service
public class ObjectService {
    private final ObjectClient objectClient;

    public ObjectService(ObjectClient objectClient) {
        this.objectClient = objectClient;
    }

    public List<Object> getObjects() {
        return objectClient.getObjects();
    }



    public Object getObjectById(@PathVariable Integer id) {
        return objectClient.getObjectById(id);
    }


    public Object addObject(@RequestBody Object object) {
        return objectClient.addObject(object);
    }


    public Object updateObject(@PathVariable Integer id, @RequestBody Object object) {
        return objectClient.updateObject(id, object);
    }


    public Object partialUpdateObject(@PathVariable Integer id, @RequestBody Object object) {
        return objectClient.partialUpdateObject(id, object);
    }


    public Object deleteObject(@PathVariable Integer id) {
        return objectClient.deleteObject(id);
    }
}
