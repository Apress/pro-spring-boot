@Grab('spring-boot-starter-test')

class MyTest{    
	
	@Test
	void testService() {
		String str= "JUnit works"
		assertEquals "JUnit works",str 
	}
}
