package booking_service.dq.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
/*@ComponentScan({"booking_service.dq.com.repository"})
@EntityScan("booking_service.dq.com.entity")
@EnableJpaRepositories("booking_service.dq.com.repository")*/
//@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class JavaBookingApplication {

/*
	@RequestMapping("/")
	String home() {
		return "error World!";
	}
*/


	public static void main(String[] args) {
		SpringApplication.run(JavaBookingApplication.class, args);
	}
//        SpringApplication.setRegisterShutdownHook(false)

}
