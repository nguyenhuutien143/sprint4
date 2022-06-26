package fis_training.repo;


import fis_training.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {
//    Optional<Person> findByUsername(String username);
//
//    default Set<Person> findAllByUsernamePart(String part){
//        return Set.of();
//    }
//
//    Optional<Person> findByCompleteName(String firstName, String lastName);
//
//    Set<Person> findAll();
//
//    int updatePassword(Long personId, String newPass);
//
//    long count();
//
//    default Map<String, Object> findByIdAsMap(Long id) {
//        return new HashMap<>();
//    }
//
//    default List<Map<String, Object>> findAllAsMaps() {
//        return new ArrayList<>();
//    }
//
//    default void htmlAllByName(String name) {}
//
//    default int createPerson(Long userId, String username, String firstName, String lastName, String password) {
//        return 0;
//    }
//
//    default List<String> findAllUsernames() { return List.of();}
//
//    default List<Person> findAllByLastName(String firstName){return List.of();};
}
