package org.example.base;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public abstract class BaseMongoService<T, ID> {

    private final BaseMongoRepository<T, ID> baseMongoRepository;

    private final Class<T> type;

    @Autowired
    public BaseMongoService(BaseMongoRepository<T, ID> baseMongoRepository, Class<T> type) {
        this.baseMongoRepository = baseMongoRepository;
        this.type = type;
    }

    public T save(T entity) {
        return baseMongoRepository.save(entity);
    }

    public List<T> getAll() {
        return baseMongoRepository.findAll();
    }

    public T getById(ID id) {
        return baseMongoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public T update(ID id, T updatedEntity) {
        if (!baseMongoRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found!");
        }

        baseMongoRepository.deleteById(id);

        return baseMongoRepository.save(updatedEntity);
    }

    public T delete(ID id) {
        T t = (T) baseMongoRepository.findById(id);
        baseMongoRepository.deleteById(id);
        return t;
    }

}
