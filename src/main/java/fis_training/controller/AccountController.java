package fis_training.controller;


import fis_training.model.Person;
import fis_training.model.role.Role;
import fis_training.model.role.UserRole;
import fis_training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private PersonService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountController(PersonService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/")
    public Person createUser(@RequestBody Person user) throws Exception {
        user.setCreateAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        user.setHiringDate(LocalDateTime.now());
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roleSet = new HashSet<>();
        Role role = new Role();
        role.setRoleId(1L);
        role.setRoleName("TRAINEE");
        UserRole userRole = new UserRole();
        userRole.setPerson(user);
        userRole.setRole(role);
        roleSet.add(userRole);
        return this.userService.createUser(user, roleSet);
    }

}
