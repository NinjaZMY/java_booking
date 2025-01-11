package booking_service.dq.com.service;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

//import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

//@EnableAutoConfiguration
@Service

public class BlogService {

    @Autowired
    BlogRepository repository;
    ObjectMapper objectMapper; // For JSON parsing
    boolean isContentProvided,isTypeProvided;
    private Blog blog;
//    @Lazy
/*    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }*/

//@Autowired

    public List<Integer> getAllIds() {
        return repository.findAllIds();
    }

    public List<Blog> getAllBlogs()
    {
//        return repository.findAll();//no sorting
//        return repository.findAllByOrderByIdDesc();
        return repository.findAllByOrderByIdAsc();
    }

    public String saveBlog(Blog b)
    {
    saveDB(b, isContentProvided, isTypeProvided);
    return "Blog Saved";
    }

    public String deleteBlog(int id) {
        repository.deleteById(id);
        return "Blog Saven't";
    }

    public String updateBlog(Blog b)
    {
    saveDB( b,isContentProvided, isTypeProvided);
    return "{'MESSAGE':'inshallah sné', 'UpdatedRow':"+to_JSON(b)+"}";
    }

    public <T> String to_JSON(T s)
    {
        try {
            return objectMapper.writeValueAsString(s);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error converting to JSON";
        }//end of try - catch Exception e

    }//end of to_JSON function



    public String insideSaveDB( Blog c, boolean isContentProvided, boolean isTypeProvided)
    {
         if(!isContentProvided || !isTypeProvided)
        {
            Optional<Blog> op = getBlogById(c.getId());
            if(op.isPresent()){
                Blog p= op.get();
                if (!isContentProvided) {
                    String pc = p.getContent();

                    c.setContent(pc);
                }//end of if not is content provided
                if (!isTypeProvided) {
                    String pt = p.getType();
                    c.setType(pt);
                }//end of if not Type provided
            }//end of if Present of p Blog

        }//end of no content provided x no type provided
        String log="";
        String t=c.getType();
        String[] validValues = {"a", "b", "c"}; // Define the array
        if (Arrays.asList(validValues).contains(t)) {
            System.out.println(true);
        } else {
            c.setType(validValues[0]);
        }//end of ARRAYS HAS VALiD VALUES

        log="> b : '"+c+"'";
        repository.save(c);
        return log;
    }//end of insideSAVEDB


    /*public String insideSaveDB( Blog c, boolean isContentProvided, boolean isTypeProvided)
    {

    }*/

    public String saveDB( Blog c, boolean isContentProvided, boolean isTypeProvided)
    {



        return insideSaveDB(c,isContentProvided,isTypeProvided);

    }//end of saveDB without int

    public String saveDB( int id, Blog c, boolean isContentProvided, boolean isTypeProvided)
    {
        c.setId(id);

        return insideSaveDB(c,isContentProvided,isTypeProvided);
    }


    public Optional<Blog> getBlogById(int id) {
        return repository.findById(id);
    }

    public Blog directBlogById(int id)
    {  return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
    }

    public String updateBlogByID(int id, Blog c, boolean isContentProvided, boolean isTypeProvided) {

        return __DB_save_parent_(id,c,isContentProvided,isTypeProvided);

    } // end of UpdateBlogByID


    public String __DB_save_parent_(int id, Blog c, boolean isContentProvided, boolean isTypeProvided)
    {
    Optional<Blog> b=getBlogById(id);
    // {id : id , content : c }
        if(b.isPresent())
        {
            String s=saveDB(id,c,isContentProvided,isTypeProvided);
            return "Mamacita"+s;
        }//end of if b.isPresent()

    return "oumourek mate3jebesh";
    }//end of DB SAve PArent using id


}//end of BlogService.java