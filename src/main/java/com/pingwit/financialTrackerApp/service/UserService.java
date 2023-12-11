package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
