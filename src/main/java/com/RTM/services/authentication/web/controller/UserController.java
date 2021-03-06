package com.RTM.services.authentication.web.controller;

import com.RTM.services.authentication.domain.model.SecureUser;
import com.RTM.services.authentication.domain.model.User;
import com.RTM.services.authentication.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<SecureUser>> getUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<SecureUser> getUser(@PathVariable("id") int userId) {
        return userService.getUserById(userId)
                .map( user -> new ResponseEntity<>(user.getSecureUser(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public  ResponseEntity<SecureUser> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.newUser(user).getSecureUser(),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public  ResponseEntity<SecureUser> updateUser(@RequestBody User user){
        if (userService.updateUser(user)) return new ResponseEntity<>(user.getSecureUser(),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity updateUser(@PathVariable("id") int userId){
        if (userService.delete(userId)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
