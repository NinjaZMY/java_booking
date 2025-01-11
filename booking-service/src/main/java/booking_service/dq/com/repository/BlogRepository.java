package booking_service.dq.com.repository;

import booking_service.dq.com.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Component
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    // Find all and order by id
    List<Blog> findAllByOrderByIdAsc(); // Ascending order
    List<Blog> findAllByOrderByIdDesc(); // Descending order

    // Fetch all IDs
    @Query("SELECT b.id FROM Blog b")
    List<Integer> findAllIds();
}