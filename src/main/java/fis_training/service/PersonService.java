package fis_training.service;



import fis_training.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    Optional<Person> findByUsername(String username);

     List<Person> findAllByUsernamePart(String part);

    Optional<Person> findByCompleteName(String firstName, String lastName);

    List<Person> findAll();

    int updatePassword(Long personId, String newPass);

    long count();

//     Map<String, Object> findByIdAsMap(Long id) {
//        return new HashMap<>();
//    }
//
//    default List<Map<String, Object>> findAllAsMaps() {
//        return new ArrayList<>();
//    }

//    default void htmlAllByName(String name) {}

     int createPerson(Long userId, String username, String firstName, String lastName, String password);

//     List<String> findAllUsernames();

//    default List<Person> findAllByLastName(String firstName){return List.of();};



//    @Autowired
//    private PersonRepo jdbcPersonRepo;
//
//    public void testPersonRepo(){
//        Set<Person> personSet = jdbcPersonRepo.findAll();
//        System.out.println(personSet);
//    }
}
