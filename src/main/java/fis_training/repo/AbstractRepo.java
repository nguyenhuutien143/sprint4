package fis_training.repo;


import fis_training.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbstractRepo extends JpaRepository<AbstractEntity,Long> {
//    void save(T entity);
//    void delete(T entity);
//    T update(T entity);
//    int deleteById(Long entityId);
//    Optional<T> findById(Long entityId);
}
