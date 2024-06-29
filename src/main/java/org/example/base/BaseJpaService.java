package org.example.base;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public abstract class BaseJpaService<T, ID> {

    private final BaseJpaRepository<T, ID> baseJpaRepository;

    private final Class<T> type;

    @Autowired
    public BaseJpaService(BaseJpaRepository<T, ID> baseJpaRepository, Class<T> type) {
        this.baseJpaRepository = baseJpaRepository;
        this.type = type;
    }

    public T save(T entity) {
        return baseJpaRepository.save(entity);
    }

    public List<T> getAll() {
        return baseJpaRepository.findAll();
    }

    public T getById(ID id) {
        return baseJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    public T update(ID id, T updatedEntity) {
        if (!baseJpaRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found!");
        }

        baseJpaRepository.deleteById(id);

        return baseJpaRepository.save(updatedEntity);
    }

    public T delete(ID id) {
        T t = (T) baseJpaRepository.findById(id);
        baseJpaRepository.deleteById(id);
        return t;
    }
}
