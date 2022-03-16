package com.RTM.services.authentication.domain.service;

import com.RTM.services.authentication.domain.model.SecureUser;
import com.RTM.services.authentication.domain.model.User;
import com.RTM.services.authentication.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public List<SecureUser> getAll(){
        return  userRepository.getAll().stream()
                .map(User::getSecureUser)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(int userId){
        return userRepository.getUserById(userId);
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public User newUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean updateUser(User user){
        if (userRepository.userExist(user.getId())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        }
        else return false;
    }

    public boolean delete( int userId){
        if (userRepository.userExist(userId)){
            userRepository.delete(userId);
            return true;
        }
        else return false;
    }
}
