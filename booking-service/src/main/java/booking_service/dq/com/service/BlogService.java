package booking_service.dq.com.service;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

//@EnableAutoConfiguration
@Service

public class BlogService {

    @Autowired
    BlogRepository repository;
//    @Lazy
/*    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }*/

//@Autowired

    public List<Blog> getAllBlogs() {
        return repository.findAll();
    }

    public String saveBlog(Blog blog) {
        repository.save(blog);
        return "Blog Saved";
    }

    public Optional<Blog> getBlogById(int id) {
        return repository.findById(id);
    }
}