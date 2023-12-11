package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.Expense;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {
    @Query("SELECT c FROM Expense c WHERE c.expenseName = ?1")
    Optional<Expense> findExpenseByName(String expenseName);

    @Query("SELECT c FROM Expense c WHERE c.expenseId = ?1")
    Optional<Expense> getExpenseById(Long expenseId);

    @Query("SELECT e FROM Expense e")
    List<Expense> getAllExpenses();

    @Transactional
    @Modifying
    @Query("DELETE FROM Expense e WHERE e.expenseId = :id")
    void deleteExpenseById(@Param("id") Long id);

    @Query("SELECT e.expenseName, e.expenseAmount, e.expenseDate, e.expenseDescription, e.expenseId, c.category " +
            "FROM Expense e, Category c WHERE c.categoryId = e.categoryId " +
            "AND e.expenseDate BETWEEN :fromDate AND :tillDate")
    public List<Object[]> getExpenseByDate(@Param("fromDate") Date fromDate, @Param("tillDate") Date tillDate);

    @Query("SELECT e.expenseName, e.expenseAmount, e.expenseDate, e.expenseDescription, e.expenseId, c.category " +
            "FROM Expense e, Category c WHERE c.categoryId = e.categoryId AND e.categoryId = :categoryId")
    public List<Object[]> getExpenseByCategory(@Param("categoryId") Long categoryId);

    @Query("SELECT e.expenseName, e.expenseAmount, e.expenseDate, e.expenseDescription, e.expenseId, c.category " +
            "FROM Expense e, Category c WHERE c.categoryId = e.categoryId " +
            "AND e.categoryId = :categoryId AND e.createdDate BETWEEN :fromDate AND :tillDate")
    public List<Object[]> getExpenseByCategoryAndDate(@Param("fromDate") Date fromDate,
                                                      @Param("tillDate") Date tillDate,
                                                      @Param("categoryId") Long categoryId);

}


