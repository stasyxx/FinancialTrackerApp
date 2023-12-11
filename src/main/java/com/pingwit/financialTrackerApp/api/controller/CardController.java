package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Card;
import com.pingwit.financialTrackerApp.exception.ExpenseExistsException;
import com.pingwit.financialTrackerApp.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/card")

public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/{userId}/add-card")
    @ApiOperation("Add a new card to the system.")
    public ResponseEntity<String> addNewCard(@PathVariable Long userId, @RequestBody Card card) {
        try {
            cardService.addNewCard(userId, card);
            return new ResponseEntity<>("Card added successfully", HttpStatus.CREATED);
        } catch (ExpenseExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }
}
