import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MyTest {

	@Rule
	public OutputCapture capture = new OutputCapture();

	@Test
	public void stringTest() throws Exception {
		System.out.println("Spring Boot Test works in Java too!");
		assertThat(capture.toString(), containsString("Spring Boot Test works in Java too!"));
	}

}