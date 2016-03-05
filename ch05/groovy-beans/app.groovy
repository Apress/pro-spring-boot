@RestController
class SimpleWebApp {

    @Autowired
    String text

    @RequestMapping("/")
    String index() {
         "You can do: ${text}!"
    }
}

beans {
      text String, "Spring Boot with Groovy beans"
}
