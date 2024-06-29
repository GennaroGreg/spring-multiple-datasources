package org.example.pet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackageClasses = Pet.class,
        entityManagerFactoryRef = "petEntityManagerFactory",
        transactionManagerRef = "petTransactionManager"
)
public class PetJpaConfig {

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean petEntityManagerFactory(@Qualifier("petDataSource") DataSource petDataSource, EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(petDataSource)
                .packages(Pet.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager petTransactionManager(
            @Qualifier("petEntityManagerFactory") LocalContainerEntityManagerFactoryBean petEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(petEntityManagerFactory).getObject());
    }

}
