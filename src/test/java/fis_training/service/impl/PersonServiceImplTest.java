package fis_training.service.impl;

import fis_training.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceImplTest {
    @Autowired
    private PersonService personService;

    @Test
    void findByUsername() {
        assertEquals("NguyenTien", personService.findByUsername("NguyenTien").get().getUsername());
    }

    @Test
    void findAllByUsernamePart() {
        assertEquals(1, personService.findAllByUsernamePart("Tien").size());
    }

    @Test
    void findByCompleteName() {
        assertEquals("NguyenTien", personService.findByCompleteName("Tien","Nguyen").get().getUsername());
    }

    @Test
    void findAll() {
        assertEquals(1,personService.findAll().size());
    }

    @Test
    void updatePassword() {
        assertEquals(1, personService.updatePassword(1L,"232"));
    }

    @Test
    void count() {
    assertEquals(1,personService.count());
    }

    @Test
    void createPerson() {
        assertEquals(1,personService.createPerson(2L, "username",  "firstName",  "lastName",  "password"));

    }
}