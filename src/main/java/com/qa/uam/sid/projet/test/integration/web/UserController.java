package com.qa.uam.sid.projet.test.integration.web;

import com.qa.uam.sid.projet.test.integration.model.User;
import com.qa.uam.sid.projet.test.integration.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/test/integrations/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        this.userService.createUser(user);
    }

    @PutMapping("/users")
    public void editeUser(@RequestBody User user){
        this.userService.modifierUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> findOne(@RequestParam Long id){
       return this.userService.findUserById(id);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestParam Long id){
        this.userService.deletUser(id);
    }

}
