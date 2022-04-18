package com.RTM.services.authentication.client;

import com.RTM.services.authentication.domain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/full_user/get_by_id/{id}")
    public  ResponseEntity<User> getFullUser(@PathVariable("id") int userId);

    @GetMapping("/user/full_user/get_by_name/{username}")
    public  ResponseEntity<User> getFullUserByusername(@PathVariable("username") String username);
}
