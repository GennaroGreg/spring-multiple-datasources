package org.example.pet;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PetDatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.pet")
    public DataSourceProperties petDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource petDataSource() {
        return petDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
