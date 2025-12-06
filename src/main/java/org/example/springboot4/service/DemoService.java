package org.example.springboot4.service;

//@Service this will make spring identify this class by component scanning
//but i need to declare it in dynamic using code configuration
public class DemoService {

    public String demoName() {
        return "My name is Hossam";
    }

}
