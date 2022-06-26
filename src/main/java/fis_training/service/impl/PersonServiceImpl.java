package fis_training.service.impl;


import fis_training.core.NotFoundException;
import fis_training.model.Person;
import fis_training.repo.PersonRepo;
import fis_training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepo personRepo;
    @Override
    public Optional<Person> findByUsername(String username){
        Optional<Person> p= personRepo.findAll().stream().filter(person -> username.equals(person.getUsername())).findFirst();
        if(p.isEmpty()) throw new NotFoundException("not found");
        return p;
    }

    @Override
    public List<Person> findAllByUsernamePart(String part) {
        List<Person> personList= personRepo.findAll().stream().filter(person -> person.getUsername().contains(part)).collect(Collectors.toList());
        return personList;
    }

    @Override
    public Optional<Person> findByCompleteName(String firstName, String lastName) {
        Optional<Person> person= personRepo.findAll().stream().filter(person1 ->
                firstName.equals(person1.getFirstName())).filter(person1 -> lastName.equals(person1.getLastName())).
                findFirst();
        if(person.isPresent()) return person;
        throw new NotFoundException("not found");
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public int updatePassword(Long personId, String newPass) {
        Optional<Person> person= personRepo.findById(personId);
        person.get().setPassword(newPass);
        if(personRepo.save(person.get())==null) return -1;
        return 1;
    }

    @Override
    public long count() {
        return personRepo.count();
    }

    @Override
    public int createPerson(Long userId, String username, String firstName, String lastName, String password) {
        Person person= new Person();
        person.setPassword(password);
        person.setId(userId);
        person.setUsername(username);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        if(personRepo.save(person)!=null) return 1;
        return -1;
    }
}
