package booking_service.dq.com.controller;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

//@Component
@RestController
public class blogController {

    @Autowired
    BlogService blogService;
    ObjectMapper objectMapper; // For JSON parsing

    public blogController(BlogService blogService, ObjectMapper objectMapper) {
        this.blogService = blogService;
        this.objectMapper = objectMapper;
    }

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
    public String updateBlogByID(@PathVariable int id, @RequestBody Map<String, Object> rawBody )
    {
    // Check if "content" is explicitly mentioned in the request
    boolean isContentProvided = rawBody.containsKey("content");
    boolean isTypeProvided=rawBody.containsKey("type");

    // Convert raw JSON to Blog object
    Blog blog = objectMapper.convertValue(rawBody, Blog.class);


    // If "content" is present (even null), process as normal
    return blogService.updateBlogByID(id,blog,isContentProvided,isTypeProvided);



    }//end of UpdateBlogByID


/*
    public static String test() {
        return "Hello world\n";
    }
*/


}


