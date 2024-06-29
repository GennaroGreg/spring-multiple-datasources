package org.example.contact;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class ContactDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.contact")
    public DataSourceProperties contactDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource contactDataSource() {
        return contactDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
