package fis_training.service;


import fis_training.model.AbstractEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbstractService<T extends AbstractEntity> {
    void save(T entity);
    void delete(T entity);
    T update(T entity);
    int deleteById(Long entityId);
    Optional<T> findById(Long entityId);
    List<T> findAll();
}
