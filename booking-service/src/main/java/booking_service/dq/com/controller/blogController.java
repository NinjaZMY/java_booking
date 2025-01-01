package booking_service.dq.com.controller;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
}