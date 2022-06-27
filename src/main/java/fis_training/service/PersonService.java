package fis_training.service;

import fis_training.model.Person;
import fis_training.model.role.UserRole;

import java.util.List;
import java.util.Set;

public interface PersonService {
    Person createUser(Person user, Set<UserRole> userRoles) throws Exception;

    Person addPerson(Person person);

    Person updatePerson(Person person);

    List<Person> getPeople();

    Person getPerson(Long id);

    void deletePerson(Long id);
}
