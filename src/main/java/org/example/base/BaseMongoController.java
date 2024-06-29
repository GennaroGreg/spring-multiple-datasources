package org.example.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public abstract class BaseMongoController<T, ID> {

    private static final String BY_ID = "/{id}";

    private final BaseMongoService<T, ID> baseMongoService;

    @Autowired
    public BaseMongoController(BaseMongoService<T, ID> baseMongoService) {
        this.baseMongoService = baseMongoService;
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) {
        T createdEntity = baseMongoService.save(entity);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = baseMongoService.getAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping(BY_ID)
    public ResponseEntity<T> getById(@PathVariable() ID id) {
        T entity = baseMongoService.getById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping(BY_ID)
    public ResponseEntity<T> update(@PathVariable() ID id, @RequestBody T updatedEntity) {
        T entity = baseMongoService.update(id, updatedEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(BY_ID)
    public ResponseEntity<String> delete(@PathVariable() ID id) {
        T deletedEntity = baseMongoService.getById(id);
        baseMongoService.delete(id);
        return new ResponseEntity<>("The following entry has been deleted: \n " + deletedEntity, HttpStatus.NO_CONTENT);
    }

}
