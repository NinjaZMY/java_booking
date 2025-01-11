package booking_service.dq.com.controller;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Component
@RestController
public class blogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> getById(@PathVariable int id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/save")
    public String saveBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id) {return blogService.deleteBlog(id);}

    @PutMapping("/update")
    public String updateBlog(@RequestBody Blog blog) {  return blogService.updateBlog(blog);}

    @PutMapping("/update/{id}")
    public String updateBlogByID(@PathVariable int id, @RequestBody Blog b )
    { return blogService.updateBlogByID(id,b);   }


/*
    public static String test() {
        return "Hello world\n";
    }
*/


}


