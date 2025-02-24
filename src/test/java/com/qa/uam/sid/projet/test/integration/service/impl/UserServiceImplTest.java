package com.qa.uam.sid.projet.test.integration.service.impl;

import com.qa.uam.sid.projet.test.integration.model.User;
import com.qa.uam.sid.projet.test.integration.repo.UserRepository;
import com.qa.uam.sid.projet.test.integration.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    void shouldReturnAllUserFromService(){
        // donnees static
                List<User> users = List.of(
                        new User(1L, "ngom", "bass", 69,true),
                        new User(2L, "Diop", "Fatou", 9,true),
                        new User(3L, "FAll", "Alioune", 6,true)
                );
                // When
        when(userRepository.findAll()).thenReturn(users);



        List<User> users1 = userService.getAllUsers();
        Assert.notEmpty(users1, " Liste d'utilisateur non vide");
        Assert.isTrue(users1.size() == 3, " il y'a que 3 utilisateurs dans la bd");
        Assert.isTrue(users1.get(0).getNom().equals("ngom"), "le premier utiliseur a pour nom 'ngom'");


    }


}