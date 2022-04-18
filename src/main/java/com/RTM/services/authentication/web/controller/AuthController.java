package com.RTM.services.authentication.web.controller;

import com.RTM.services.authentication.domain.dto.AuthenticationRequest;
import com.RTM.services.authentication.domain.dto.AuthenticationResponse;
import com.RTM.services.authentication.domain.model.User;
import com.RTM.services.authentication.domain.service.UserDetailsService;
import com.RTM.services.authentication.domain.service.UserService;
import com.RTM.services.authentication.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            Map<String, Object> response = new HashMap();
            response.put("token", new AuthenticationResponse(jwt));
            response.put("user", userService.getUserByUsername(request.getUsername()).getSecureUser());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (AuthenticationException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/authorization")
    public ResponseEntity<?> getAuthorization(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
