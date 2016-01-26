@RestController
class SimpleWebApp{
    @RequestMapping("/")
    String index(){
        "Spring Boot Rocks!"
    }
}
