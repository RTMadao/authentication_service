package com.RTM.services.authentication.web.controller;

import com.RTM.services.authentication.domain.dto.AuthenticationResponse;
import com.RTM.services.authentication.domain.service.UserDetailsService;
import com.RTM.services.authentication.domain.service.UserService;
import com.RTM.services.authentication.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/encode_user/{pass}")
    public ResponseEntity<String> encodePassword(@PathVariable("pass") String pass){
        return new ResponseEntity<>(userService.encodeUserPassword(pass), HttpStatus.OK);
    }

    @GetMapping("/generate_token/{username}")
    public ResponseEntity<String> generateToken(@PathVariable("username") String username){
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String jwt = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponse(jwt).getJwt(), HttpStatus.OK);
    }
}
