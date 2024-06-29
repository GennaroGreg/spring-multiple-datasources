package org.example.contact;

import org.example.pet.Pet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = Contact.class,
        entityManagerFactoryRef = "contactEntityManagerFactory",
        transactionManagerRef =  "contactTransactionManager"
)
public class ContactJpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean contactEntityManagerFactory(
            @Qualifier("contactDataSource")DataSource contactDataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(contactDataSource)
                .packages(Contact.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager contactTransactionManager(
            @Qualifier("contactEntityManagerFactory") LocalContainerEntityManagerFactoryBean contactEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(contactEntityManagerFactory).getObject());
    }

}