package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    @Query(value = "SELECT NEW User(u.id, u.username, :uuid) FROM User u WHERE u.id = :id")
    User generateRandomUUID(@Param("id") UUID id, @Param("uuid") UUID uuid);
}
