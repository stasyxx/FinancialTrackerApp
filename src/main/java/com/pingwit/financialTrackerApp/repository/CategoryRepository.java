package com.pingwit.financialTrackerApp.repository;

import com.pingwit.financialTrackerApp.entity.Category;
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
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.categoryName = ?1")
    Optional<Category> findCategoryByName(String categoryName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c.categoryName = :category")
    void deleteCategoryByName(@Param("category") String categoryName);

    @Query("SELECT c.category FROM Category c")
    public List<String> getOnlyCategories();

    @Query("SELECT c.category FROM Category c")
    public List<Category> getCategory();

    @Query("SELECT c.categoryId FROM Category c WHERE c.category = :category")
    public Long getIdForCategory(@Param("category") String category);

	/*select c.category, SUM(e.expenseAmount)
	from CATEGORY c, Expense e
	where c.CATEGORY_ID = e.CATEGORY_ID
	group by c.CATEGORY;*/

}
