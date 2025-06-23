package com.explorespring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getUser() {
        return List.of(
                new User("Michael", "Jackson"),
                new User("Alice", "Smith"),
                new User("Bob", "Marley")
        );
    }
    record User(String firstName, String lastName) {}
}
