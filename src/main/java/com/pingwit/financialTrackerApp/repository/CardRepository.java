package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
        @Query("SELECT c.cardAmount FROM Card c")
        public List<BigDecimal> getCardAmount();

        @Query("SELECT COALESCE(c.dateOfExpire, :defaultDate) FROM Card c")
        List<Date> getDateOfExpire(@Param("defaultDate") Date defaultDate);
    }

