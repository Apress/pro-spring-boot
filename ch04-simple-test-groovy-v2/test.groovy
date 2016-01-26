class SimpleWebTest {

    @Test
    void greetingsTest() {
         assertEquals("Spring Boot Rocks!", new WebApp().greetings())
    }

}
