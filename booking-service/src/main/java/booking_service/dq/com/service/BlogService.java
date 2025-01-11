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
    private Blog blog;
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

    public String deleteBlog(int id) {
        repository.deleteById(id);
        return "Blog Saven't";
    }

    public String updateBlog(Blog blog)
    {
     repository.save(blog);
     return "inshallah sné";
    }



    public Optional<Blog> getBlogById(int id) {
        return repository.findById(id);
    }

    public String updateBlogByID(int id,Blog c) {
        Optional<Blog> b=repository.findById(id);
        // {id : id , content : c }
        if(b.isPresent())
        {
         c.setId(id);
/*         Blog B =b.get();
         B.setContent(c.getContent());
         B.setType(c.getType());*/
         repository.save(c);
         return "Mamacita";
        }
        return "oumourek mate3jebesh";
    }

}