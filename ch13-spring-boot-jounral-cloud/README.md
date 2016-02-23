### Spring Boot in the Cloud : Cloud Foundry

You can use the __cloud-connectors__ as well and get the DataSource.

##pom.xml
```xml
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-spring-service-connector</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-cloudfoundry-connector</artifactId>
	</dependency>
```

## Code
```java
package com.apress.spring.config;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {
    
	@Bean
    public DataSource dataSource() {
        return connectionFactory().dataSource();
    }
}
```