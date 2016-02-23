### Spring Boot in the Cloud : Cloud Foundry

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