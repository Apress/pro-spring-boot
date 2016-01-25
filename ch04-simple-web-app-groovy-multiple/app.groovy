@RestController
class WebApp{
	
	@Autowired
	MyService service
	
    @RequestMapping("/")
    String greetings(){
       service.getH3HeaderFrom("Spring Boot Rocks")
    }
}
