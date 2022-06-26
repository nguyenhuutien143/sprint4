package fis_training.repo;


import fis_training.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends JpaRepository<Storage,Long> {

//    Optional<Storage> findByName(String name);
//
//    Optional<Storage> findByLocation(String location);
}
