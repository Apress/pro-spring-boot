# Spring Boot in the Cloud : Cloud Foundry

You can use the __cloud-connectors__ as well and get the DataSource.

###pom.xml
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

### Code
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

### Runing local (no Cloud Foundry) emulate cloud profile
__VCAP_APPLICATION__
```json
{
    "application_name": "journal",
    "application_uris": [""],
    "application_version": "1",
    "host": "localhost",
	"port": 8080,
    "instance_id": "abcd",
    "instance_index": 0,
    "name": "journal",
    "version": "1.0"
}
```

__VCAP_SERVICES__
```json
{
    "p-mysql": [
        {
            "credentials": {
                "uri": "jdbc:mysql://localhost/journal?user=spring&password=springboot"
            },
            "label": "MySQL Service",
            "name": "p-mysql",
            "plan": "100mb-dev",
            "tags": [
                "mysql"
            ]
        }
    ]
}
```