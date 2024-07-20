package com.example.SeedsUserAuth.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint methods will be added here
    @PostMapping("/register")
    public User registerUser(@RequestParam String username, @RequestParam String password) {
        return userService.registerNewUser(username, password);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam String username, @RequestParam String newPassword) {
        return userService.updateUser(username, newPassword);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }




}
