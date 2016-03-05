import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration

@RestController
@EnableAutoConfiguration(exclude=[ActiveMQAutoConfiguration.class])
class WebApp{

    @RequestMapping("/")
	  String greetings(){
	       "Spring Boot Rocks"
	  }
}
			
