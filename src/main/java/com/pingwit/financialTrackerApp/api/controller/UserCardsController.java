package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Card;
import com.pingwit.financialTrackerApp.entity.User;
import com.pingwit.financialTrackerApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserCardsController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/cards")
    public ResponseEntity<List<Card>> getCardsByUserId(@PathVariable Long userId) {
        List<Card> userCards = userService.getCardsByUserId(userId); //TODO add method getCardsByUserId
        return new ResponseEntity<>(userCards, HttpStatus.OK);
    }

    @PostMapping("/{userId}/add-card")
    public ResponseEntity<String> addNewCard(@PathVariable Long userId, @RequestBody Card card) {
        userService.addCardToUser(userId, card);
        return new ResponseEntity<>("Card added successfully", HttpStatus.CREATED);
    }
}