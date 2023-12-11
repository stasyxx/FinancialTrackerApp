package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Card;
import com.pingwit.financialTrackerApp.entity.User;
import com.pingwit.financialTrackerApp.exception.CardExistsException;
import com.pingwit.financialTrackerApp.exception.ExpenseExistsException;
import com.pingwit.financialTrackerApp.service.CardService;
import com.pingwit.financialTrackerApp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/add-card")
    @ApiOperation("Add a new card to the system.")
    public ResponseEntity<String> addNewCard(@RequestBody Card card) {
        try {
            cardService.addNewCard(card);
            return new ResponseEntity<>("Card added successfully", HttpStatus.CREATED);
        } catch (CardExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

    @GetMapping("/card-amount")
    @ApiOperation("Returns card amount.")
    public BigDecimal getCardAmount(@RequestParam Long cardId) {
        BigDecimal cardAmount = cardService.getCardAmount(cardId);
        return cardAmount;
    }

    @GetMapping("/date-of-expire")
    @ApiOperation("Returns date of expire for card.")
    public Date getDateOfExpire() {
        Date dateOfExpire = cardService.getDateOfExpire();
        return dateOfExpire;
    }
}
