class SimpleWebTest {

    @Test
    void indexTest() {
         assertEquals("Spring Boot Rocks!", new SimpleWebApp().index())
    }

}
