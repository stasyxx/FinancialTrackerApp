package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
