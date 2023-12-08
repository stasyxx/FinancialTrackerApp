package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {

}
