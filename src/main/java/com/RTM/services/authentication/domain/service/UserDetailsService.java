package com.RTM.services.authentication.domain.service;

import com.RTM.services.authentication.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.RTM.services.authentication.domain.model.User user = userClient.getFullUserByusername(username).getBody();
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
