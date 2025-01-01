package booking_service.dq.com.repository;

import booking_service.dq.com.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}