@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.Specification
import org.springframework.boot.test.OutputCapture

class SimpleSpockTest extends Specification {

    @org.junit.Rule
    OutputCapture capture = new OutputCapture()


    def "get output and capture it"() {
        when:
        print 'Spring Boot works with Spock'

        then:
        capture.toString() == 'Spring Boot works with Spock'
    }

}

