package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
    User findByUsername(String username);
}
