package com.RTM.services.authentication.domain.service;

import com.RTM.services.authentication.client.UserClient;
import com.RTM.services.authentication.domain.exception.UserNotFoundException;
import com.RTM.services.authentication.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserClient userClient;

    public String encodeUserPassword(String pass) {
        return passwordEncoder.encode(pass);
    }

    public Boolean matchUserPassword(int userId, String testPassword) throws UserNotFoundException {
        ResponseEntity<User> response = userClient.getFullUser(userId);
        if (response.getStatusCode().is2xxSuccessful()) return passwordEncoder.matches(testPassword, response.getBody().getPassword());
        else throw new UserNotFoundException("Usuario No encontrado");
    }

    public Optional<User> getUserById(int userId){
        return Optional.of(userClient.getFullUser(userId).getBody());
    }

    public User getUserByUsername(String username){
        return userClient.getFullUserByusername(username).getBody();
    }
}
