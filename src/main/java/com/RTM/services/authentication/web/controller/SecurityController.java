package com.RTM.services.authentication.web.controller;

import com.RTM.services.authentication.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService;

    @GetMapping("/encode_user/{pass}")
    public ResponseEntity<String> encodePassword(@PathVariable("pass") String pass){
        return new ResponseEntity<>(userService.encodeUserPassword(pass), HttpStatus.OK);
    }
}
