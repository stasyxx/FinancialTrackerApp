package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.User;
import com.pingwit.financialTrackerApp.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/generate-random-uuid")
    @ApiOperation("Generates random UUID for a user.")
    public ResponseEntity<User> generateRandomUUID(@RequestParam UUID userId) {
        UUID randomUUID = UUID.randomUUID();
        User userWithRandomUUID = userRepository.generateRandomUUID(userId, randomUUID);
        return ResponseEntity.ok(userWithRandomUUID);
    }

}
