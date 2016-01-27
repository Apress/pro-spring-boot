@RestController
class WebApp{

    @RequestMapping("/showMessage.html")
    String greetings(){
        "Spring Boot MVC is easier"
   }
}
