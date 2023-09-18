package com.myproject.user.controller;

import com.myproject.user.model.User;
import com.myproject.user.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  public User saveUser(@RequestBody User user) {
    return service.saveUser(user);
  }

  @GetMapping("/allUsers")
  public List<User> getAllUsers() {
    return service.getAllUsers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
    Optional<User> optionalUser = service.getUserById(id);
    return optionalUser
        .map(user -> new ResponseEntity(user, HttpStatus.OK))
        .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteUserById(@PathVariable Long id) {
    return new ResponseEntity<>(service.deleteUserById(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return new ResponseEntity(service.updateUser(user), HttpStatus.OK);
  }
}
