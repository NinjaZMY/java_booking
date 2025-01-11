package booking_service.dq.com.service;

import booking_service.dq.com.entity.Blog;
import booking_service.dq.com.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

//import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

//@EnableAutoConfiguration
@Service

public class BlogService {

    @Autowired
    BlogRepository repository;
    boolean isContentProvided,isTypeProvided;
    private Blog blog;
//    @Lazy
/*    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }*/

//@Autowired

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
    saveDB(b, isContentProvided, isTypeProvided);
    return "inshallah sné";
    }

    public String saveDB(Blog b, boolean isContentProvided, boolean isTypeProvided)
    {
    String log="";
    String t=b.getType();
    String[] validValues = {"a", "b", "c"}; // Define the array
     if (Arrays.asList(validValues).contains(t)) {
              System.out.println(true);
        } else {
            b.setType(validValues[0]);
        }
   /* String c= b.getContent();
    Optional<String> d = Optional.ofNullable(c).flatMap(String::describeConstable);
    boolean e=d.isPresent();
    int id = b.getId();
    Blog P = directBlogById(id);
    String pc = P.getContent();
    boolean c0=b.toString().contains("content");
    log+=" > c : '"+c+"'\n"+"c0 : "+c0+" ; c0=b.toString().contains(\"content\"); \n b : '"+b.toString()+"' ;\n";

        if(e){
            boolean pc0 = pc == null;
            if(c0)
            {
                if (!pc0 ) {
                    
                    b.setContent(c);
            
                }//end of not pc0 before else
                else
                {//if pc0
                b.setContent(c);
                }//endof not empty;
            }//end of if c0
        }
        else
        {
            if(c0)
            {b.setContent(c);}
            else
            {
            b.setContent(pc);
            }//end of not c0     
        }//endof if e*/
    log="> b : '"+b+"'";
    repository.save(b);
        return log;
    }


    public Optional<Blog> getBlogById(int id) {
        return repository.findById(id);
    }

    public Blog directBlogById(int id)
    {  return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
    }

    public String updateBlogByID(int id, Blog c, boolean isContentProvided, boolean isTypeProvided) {
        Optional<Blog> b=getBlogById(id);
        // {id : id , content : c }
        if(b.isPresent())
        {
        c.setId(id);
            if(!isContentProvided || !isTypeProvided)
            {
            Blog p = directBlogById(id);

                if(!isContentProvided) {
                    String pc = p.getContent();

                    c.setContent(pc);
                }//end of if not is content provided
                if (!isTypeProvided) {
                    String pt=p.getType();
                    c.setType(pt);
                }//end of if not Type provided

            }//end of no content provided x no type provided


/*         Blog B =b.get();
         B.setContent(c.getContent());
         B.setType(c.getType());*/
        String s=saveDB(c,isContentProvided,isTypeProvided);
        return "Mamacita"+s;
        }//end of if b.isPresent()
        return "oumourek mate3jebesh";
    } // end of UpdateBlogByID



}//end of BlogService.java