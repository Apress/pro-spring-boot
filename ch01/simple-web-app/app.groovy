@RestController
class WebApp{

    @RequestMapping("/")
    String greetings(){
        "<h1>Spring Boot Rocks</h1>"
   }
}
