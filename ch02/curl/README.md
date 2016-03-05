# Spring Initializr with cURL

Minimum Maven project.
```bash
$ curl -s https://start.spring.io/starter.zip -o myapp.zip
```

Minimum Gradle project.
```bash
$ curl -s https://start.spring.io/starter.zip -o myapp.zip –d type=gradle-project
```

Spring Boot with Web Features (Spring MVC).
```bash
$ curl -s https://start.spring.io/starter.zip -o myapp.zip -d type=maven-project -d dependencies=web
```

Generates only the pom.xml with web and jpa dependencies.
```bash
$ curl -s https://start.spring.io/pom.xml -d packaging=war -o pom.xml -d dependencies=web,data-jpa
```

Generates only the build.gradle with web and jpa dependencies.
```bash
$ curl -s https://start.spring.io/build.gradle -o build.gradle -d dependencies=web,data-jpa
```

Prints out the help and all the commands available.
```bash
$ curl start.spring.io
```
