package booking_service.dq.com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.mockito.Mockito;
import org.springframework.web.bind.annotation.RestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestExecutionListeners
@SpringBootTest
@RestController
class JavaBookingApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private MockMvc mockMvc;

/*
@GetMapping("/")
public String test()
{
	return "inside tests";
}*/

	/*@Test
	public void testPrintMessage() throws Exception {
		// Sending a request to the controller
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())  // Verifying HTTP status
				.andExpect(content().string("This is the message displayed on the webpage.")); // Verifying the message
	}*/

}
