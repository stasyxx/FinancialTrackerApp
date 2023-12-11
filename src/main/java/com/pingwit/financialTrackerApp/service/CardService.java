package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.entity.Card;
import com.pingwit.financialTrackerApp.exception.CardExistsException;
import com.pingwit.financialTrackerApp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public BigDecimal getCardAmount(Long cardId) {
        return cardRepository.getCardAmount(cardId);
    }

    public Date getDateOfExpire() {
        Date defaultDate = java.sql.Date.valueOf("2027-02-19");
        return cardRepository.getDateOfExpire(defaultDate);
    }
    public void addNewCard(Card card) throws CardExistsException {
        cardRepository.save(card);
    }
}
