package com.pingwit.financialTrackerApp.api.dto;

import java.util.UUID;

public class UserDTO {

    private UUID userId;
    private String username;

    public UserDTO() {
    }

    public UserDTO(UUID userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
