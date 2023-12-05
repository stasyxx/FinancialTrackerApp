package financialTrackerApp.repository;

import financialTrackerApp.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository {
    List<User> findByUserId(Long userId);
}
