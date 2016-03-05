@RestController
class WebApp{
    @RequestMapping("/")
    String greetings(){
        "Spring Boot Rocks!"
    }
}
