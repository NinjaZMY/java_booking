package booking_service.dq.com;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;*/

//import org.mockito.Mockito;
// @GetMapping("/")
@RestController
public class HomeController
//        extends WebSecurityConfigurerAdapter
        implements ApplicationListener<ContextRefreshedEvent>  {

    private static boolean canReload = true;
    public ContextRefreshedEvent e; 
    static String log="";
    // This will be the test endpoint
    static String response;

    @GetMapping("/error")
    public String error()
    {
        return "error";
    }

    public String ConsumeAPI(String url)
    {
        url = "https://catfact.ninja/fact";
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(url, String.class) + "</center>";
    }

    /**
//     * @return
     */
    // Method to reload the page based on the 'canReload' flag
    // This will handle the root endpoint and both reload and test functionality
//    @GetMapping("/")
    @RequestMapping("/")
    private ResponseEntity<String> reloadPage() {
        // Return null since we're writing directly to the response

        if (canReload) {
//            log+="can Reload";
// Trigger a backend-driven page reload by redirecting
                                                //response.sendRedirect("/");  // Corrected path

            canReload = false;  // Disable further reloads
            /*HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/"); // Redirects to the root path
            log+="<br>"+new ResponseEntity<>(headers, HttpStatus.FOUND);*/
//            log+=test()+"<br>hey hey <script> alert('first reload');location.reload()</script></div>";

        } else {
            // If reloading is disabled, send a message to the client

            response = ConsumeAPI("https://catfact.ninja/fact");

/*            String str = "<script> $1=String(" + response + "); console.log('$1 : ',$1 ) </script>";
            response=str+response;*/
            //            response= test()+log+"<br>Reloading Disabled!<script> alert('sasuke can reload using only backend');  </script></div>";
            //statement above for debuging purposes
        }

//        response=log+response;
        response=log+response +"<script>console.log('$1 : ',$1=JSON.parse(document.body.getElementsByTagName(\"center\")[0].innerText.substr(26)))</script>";
        return ResponseEntity.ok(response);



    }//end of reloadPage() MEthod


    public static String test() {

        return "- problem solved ?? - fumbling update ?? ??  <div align=center>hey testing ???? "+canReload;  // A simple response for the root endpoint
//        return "-  problem solved- fumbling update ??   <div align=center>hey testing ???? "+canReload;  // A simple response for the root endpoint
//        return "- Solved real- fumbling update ??   <div align=center>hey testing ???? "+canReload;  // A simple response for the root endpoint
    }/**/



/* 
    public static void main(String[] args) throws IOException
    {

        System.out.println("\nhello");

    }//end of main
 */
//  @GetMapping("/")
    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
    // Trigger any custom logic when the app restarts, e.g., reload page, refresh state, etc.

    // Mocking HttpServletResponse
//    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        try {
            // Simulate the reload by calling the controller method
            log+= "<style>body\n" +
                    "{\n" +
                    "    background-color:black;\n" +
                    "    color:white;\n" +
                    "}</style><center>Live Inside Back-end app <br><br><script>alert(\" refresh ... Triggering \"); " +
                    " x='http://'+location.hostname+':35729/livereload.js' ;" +
//                    " x=livereload.js?snipver=1&port=8081' " +
                    "y= '<script src=' + x +  '>\\<'+'/script>';"+
                     "(async () => {const script = document.createElement('script');"+
                    "  script.src = x ;"+
                    "  document.body.append(script);"+
                    "  await new Promise((res) => script.onload = () => res()); })();"+
                    "$0=document.querySelectorAll('script');i=$0.length-1; $0=$0[i];  "+
                    "console.log(' x = ',x,'\\n y = ',y,'\\n$0 = ',$0.outerHTML );</script>";
                    /*"onload=()=>{document.body.innerHTML+= y;$0=document.querySelectorAll('script');i=$0.length-1; $0=$0[i];" +
                    "console.log(' x = ',x,'\\n y = ',y,'\\n$0 = ',$0 ); $0.onload=()=>console.log('script loaded') }</script>";*/
//                    "$0=document.querySelectorAll('script');" +
//                    "i=$0.length-1; $0=$0[i]; "+
//                    "console.log(' x = ',x,'\\n y = ',y,'\\n$0 = ',$0 ) </script>";
//                    "<script src=location.hostname+\":35729\"+\"/livereload.js\" ></script>";

            reloadPage();
        } catch (Exception e) {
            throw new RuntimeException("Error oh ?? triggering reload", e);
        }




    }//end of public onApplicationEvent


// @GetMapping("/c")


/*
    @Override
    protected void configure( HttpSecurity http)   WebSecurityConfigurerAdapter throws Exception {
        http.headers().cacheControl().disable();
    }
*/


}//end of HomeController


