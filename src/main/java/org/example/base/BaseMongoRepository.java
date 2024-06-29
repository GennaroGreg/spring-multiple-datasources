package org.example.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMongoRepository<T, ID> extends MongoRepository<T, ID> {

}
